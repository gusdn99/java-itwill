package com.itwill.ver02;

import com.itwill.ver01.Contact;

public class ContactDaoImpl implements ContactDao { // Controller

	// ----- singleton 구현
	private static ContactDaoImpl instance = null;

	private ContactDaoImpl() {}

	public static ContactDaoImpl getInstance() {
		if (instance == null) {
			instance = new ContactDaoImpl();
		}
		return instance;
	}
	// ----- singleton 구현

	private Contact[] contacts = new Contact[MAX_LENGTH];
	private int count = 0;

	public boolean isValidIndex(int index) {
		return (index >= 0) && (index < count);
	}

	public boolean isStorageFull() {
		return (count == MAX_LENGTH);
	}

	@Override
	public int create(Contact contact) {
		if (isStorageFull()) {
			return 0;
		}

		contacts[count] = contact;
		count++;
		return 1;
	}

	@Override
	public Contact[] read() {
		for (int i = 0; i < count; i++) {
			Contact[] result = new Contact[count];
			result[i] = contacts[i];
		}
		return contacts;
	}

	@Override
	public Contact read(int index) {
		if ((isValidIndex(index))) {
			return contacts[index];
		} else {
			return contacts[index];
		}
	}

	@Override
	public int update(int index, Contact contact) {
		if (isValidIndex(index) && contact != null) {
//			contacts[index].setName(contact.getName());
//			contacts[index].setPhone(contact.getPhone());
//			contacts[index].setEmail(contact.getEmail());
			contacts[index] = contact;
			return 1;
		} else {
			return 0;
		}
	}

}
