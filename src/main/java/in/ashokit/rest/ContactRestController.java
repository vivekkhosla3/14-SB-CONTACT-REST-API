package in.ashokit.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.binding.Contact;
import in.ashokit.constants.AppConstants;
import in.ashokit.props.AppProperties;
import in.ashokit.service.ContactService;

@RestController
@CrossOrigin
public class ContactRestController {
	
	@Autowired
	private ContactService service;
	
	@Autowired
	private AppProperties appProps;
	
	@GetMapping("/contacts")
	public List<Contact> getData() {		
		return service.getContactsData();
		}
	
	@GetMapping("/getContactById")
	public Contact getContactById(Integer contactId) {		
		return service.getContactById(contactId);
	}	
	@PostMapping("/addContact")	
	public String addContact(@RequestBody Contact contact) {	
		//return service.addcontacts(contact);
		boolean status = service.saveContact(contact);
		Map<String, String> messages = appProps.getMessages();
		
		if (status) {
			return messages.get(AppConstants.CONTACT_SAVE_SUCC);
		}
		else
		{
			return messages.get(AppConstants.CONTACT_SAVE_FAIL);
		}
		
	}
	
	@PostMapping("/updateContact")	
	public boolean updateContact(@RequestBody Contact contact) {		
		return service.saveContact(contact);		
		}	
	
	@DeleteMapping("/deleteContactById")	
	public boolean deleteContactById(@RequestParam Integer contactId) {		
		return service.deleteContactById(contactId);		
		}
	
	@PutMapping("/deleteContactByIdPut")	
	public boolean deleteContactByIdPut(@RequestBody Contact contactId) {		
		return service.deleteContactByIdPut(contactId);		
		}
	
	@DeleteMapping("/mydeleteContactById")	
	public void mydeleteContactById(@RequestParam Integer contactId) {		
		service.mydeleteContactById(contactId);		
		}
	
}
	

