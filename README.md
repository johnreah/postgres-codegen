# Postgres Code Generation

This project is a follow-on to [postgres-transactions](https://github.com/johnreah/postgres-transactions), which was an
experiment with different approaches to RDBMS transaction management in Java. That project looked at JDBC, ORMLite and
Spring Data JPA. Because my intention was to look for a solution to some problems in a real project that was already
using code generation, this second project looked a bit more deeply into how those problems might be addressed without
requiring huge code changes that would hurt productivity. This time the options included code generation from NetBeans,
Hibernate Tools and Telosys.

The main drivers for the project were:
- Enable transactions that span mutliple entities (the target project used generated DAO objects that assumed 
  control over connections and transactions but only worked with single entities)
    
- Encourage a layered architecture with transaction management brought out of the DAOs and into the service or
  application layers
  
- Favour database-first design, to reduce confusion about whether the database schema or the Java entities are the
  master. (In my experience it can be the Java code at the very beginning, but very soon it needs to become the
  database, so you may as well start out that way. And with Docker enabling you to spin up a real database in seconds
  there's really no excuse not to.)
  
- Generate the code as part of the Maven build. Treat it as ephemeral. Don't check it into your CMS. Generate it in
  the /target directory, and smile to yourself every time `mvn clean` deletes it. 

- Avoid tinkering with generated code if at all possible. You can customise Hibernate's entity generation using
  configuration options and templates, and you can use generated DAO classes by extension or composition to avoid
  modifying them. If you modify them, you have to commit lots of boilerplate to your code base, which is not very DRY
  and makes it hard to incorporate future releases of codegen libraries.
  
- Favour an option that can be integrated relatively smoothly into your target codebase

What I learned:
- There are quite a few approaches out there, with surprisingly different levels of support for DAO generation
- If you want a mature framework that has a low learning curve (especially if you're familiar with SQL), and if you are
  happy with a programmatic approach to transaction management, then ORMLite should be on your shortlist. Be aware that
  it doesn't do many-to-many though.
- JPA entities can be annotated either on fields or on property getters. Hibernate Tools annotates properties, and
  ORMLite wants its annotations on fields. I couldn't configure Hibernate Tools to annotate fields so had to resort to
  editing the templates. Thanks to
  [Martijn Pieters](https://stackoverflow.com/questions/1861817/hibernate-moving-annotations-from-property-method-level-to-field-level)
  for this. Once my Hibernate-generated entities were talking to ORMLite, I had a viable solution (but not the best). 
- I have spent at least 15 years being fairly terrified of Spring, despite using it on several projects. However it
  really is the dog's boll*cks. A combination of Entity code generated by the hibernate-tools-maven plugin with
  persistence classes based on Spring Data JPA with its support for generating queries from method names
  (`findByAgeOrderByLastnameDesc` for example) and of course its support for declarative transactions seems an
  excellent choice. Whether it's the right one for our use case remains to be seen.