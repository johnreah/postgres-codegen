/*
 * Created on 2021-11-04 ( Date ISO 2021-11-04 - Time 13:31:49 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.4.0
 */
package com.johnreah.accounts.telosysjpa.generated.data.record.listitem;

import com.johnreah.accounts.telosysjpa.generated.data.record.CustomerRecord;
import com.johnreah.accounts.telosysjpa.generated.commons.ListItem;

public class CustomerListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public CustomerListItem(CustomerRecord customer) {
		super();

		this.value = ""
			 + customer.getId()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = customer.toString();
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public String getLabel() {
		return label;
	}

}
