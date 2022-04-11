package in.ashokit.repository;
import in.ashokit.binding.Contact;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

	List<Contact> findByActiveSw(String switchSw);

}
