package com.itwill.ver03;

import java.util.ArrayList;
import java.util.List;

import com.itwill.ver01.Contact;

public class ContactDaoImpl implements ContactDao {

	// ----- singleton 구현
	private static ContactDaoImpl instance = null;

	private ContactDaoImpl() {
	}

	public static ContactDaoImpl getInstance() {
		if (instance == null) {
			instance = new ContactDaoImpl();
		}
		return instance;
	}
	// ----- singleton 구현

	private List<Contact> contacts = new ArrayList<>();
//	private int count = 0;

	public boolean isValidIndex(int index) {
		return (index >= 0) && (index < contacts.size());
	}

	@Override
	public int create(Contact contact) {
		contacts.add(contacts.size(), contact);
//		count++;
		return 1;
		
//		try {
//            contacts.add(contact);
//            return 1;
//        } catch (Exception e) {
//            return 0;
//        }
	}

	@Override
	public List<Contact> read() {
		for (int i = 0; i < contacts.size(); i++) {
			contacts.get(i);
		}
		return contacts;
	}

	@Override
	public Contact read(int index) {
		if ((isValidIndex(index))) {
			return contacts.get(index);
		} else {
			return null;
		}

	}

	@Override
	public int update(int index, Contact contact) {
		if (isValidIndex(index) && contact != null) {
//			contacts.get(index).setName(contact.getName());
//			contacts.get(index).setPhone(contact.getPhone());
//			contacts.get(index).setEmail(contact.getEmail());
			contacts.set(index, contact);
			return 1;
		} else {
			return 0;
		}

	}

	@Override
	public int delete(int index) {
		if (isValidIndex(index)) {
			contacts.remove(index);
//			count--;
			return 1;
		} else {
			return 0;
		}
	}

}
