package in.ashokit.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.ashokit.binding.Contact;
import in.ashokit.repository.ContactRepository;

@Service
public class ContactService {
	
	@Autowired
	private ContactRepository contactRepository;
	
	public List<Contact> getContactsData() {		
		/*
		 * Contact c1 = new Contact(1, "Anil", "Anil.Kumar@hotmail.com", "6047631888");
		 * Contact c2 = new Contact(2, "Bushan", "Bushan.Kumar@hotmail.com",
		 * "6047631844"); Contact c3 = new Contact(3, "Kamal",
		 * "Kamal.Kumar@hotmail.com", "6047631883"); Contact c4 = new Contact(4,
		 * "ARaghavnil", "Raghav.Kumar@hotmail.com", "6047631888"); return
		 * Arrays.asList(c1,c2,c3,c4);
		 */
		Contact contact = new Contact();
		contact.setactiveSw("Y");
		
				
		//return contactRepository.findAll(Example.of(contact));
		List<Contact> sw = contactRepository.findByActiveSw("Y");

		return sw;
		/*
		 * System.out.println("g wala test"); return (List<Contact>)
		 * contactRepository.findAll();
		 */
	}
	
	public boolean saveContact(Contact contact) {
		//ToDo
		contact.setactiveSw("Y");
		
		Contact save =  contactRepository.save(contact);
		
		if (save.getContactId() != null) {
			return true;			
		}
		
		return false;
	}
	
	public Contact getContactById(Integer contactId) {		
		//ToDo		
	
		Optional<Contact> findById = contactRepository.findById(contactId);
		if(findById.isPresent()) {
			System.out.println("found the id");
			return findById.get();			
		}
	   return null;	
	}
	
	public Contact updateContact(Contact contact) {
		//ToDo
		return contact;
	}
	
	public boolean deleteContactById(Integer contactId) {
		//ToDo
		System.out.println("yes ashokid at delete" );
		Optional<Contact> findById = contactRepository.findById(contactId);
		if(findById.isPresent()) {
			Contact contact = findById.get();
			contact.setactiveSw("N");
			contactRepository.save(contact);
			return true;
			
		}
		return false;
	}
	
	
	public boolean deleteContactByIdPut(Contact contactId) {
		//ToDo
		System.out.println("yes try at delete" );
		Optional<Contact> findById = contactRepository.findById(contactId.getContactId());
		if(findById.isPresent()) {
			Contact contact = findById.get();
			contact.setactiveSw("N");
			contactRepository.save(contact);
			return true;
			
		}
		return false;
	}

	


public void mydeleteContactById(Integer contactId) {
	System.out.println("yes rec at delete" );
	contactRepository.deleteById(contactId);
}
	
}
