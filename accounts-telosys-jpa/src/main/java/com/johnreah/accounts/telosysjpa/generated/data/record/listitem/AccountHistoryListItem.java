/*
 * Created on 2021-11-04 ( Date ISO 2021-11-04 - Time 13:31:49 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.4.0
 */
package com.johnreah.accounts.telosysjpa.generated.data.record.listitem;

import com.johnreah.accounts.telosysjpa.generated.data.record.AccountHistoryRecord;
import com.johnreah.accounts.telosysjpa.generated.commons.ListItem;

public class AccountHistoryListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public AccountHistoryListItem(AccountHistoryRecord accountHistory) {
		super();

		this.value = ""
			 + accountHistory.getId()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = accountHistory.toString();
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
