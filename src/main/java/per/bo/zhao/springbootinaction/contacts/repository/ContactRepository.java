package per.bo.zhao.springbootinaction.contacts.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import per.bo.zhao.springbootinaction.contacts.domain.Contact;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class ContactRepository {

    @Resource
    private JdbcTemplate jdbcTemplate;

    public List<Contact> findAll() {
        return jdbcTemplate.query("select id, firstName, lastName, phoneNumber, " +
                        "emailAddress from contacts order by lastName",
                (resultSet, i) -> {
                    Contact contact = new Contact();
                    contact.setId(resultSet.getLong(1));
                    contact.setFirstName(resultSet.getString(2));
                    contact.setLastName(resultSet.getString(3));
                    contact.setPhoneNumber(resultSet.getString(4));
                    contact.setEmailAddress(resultSet.getString(5));
                    return contact;
                });
    }

    public void save(Contact contact) {
        jdbcTemplate.update("insert into contacts (firstName, lastName, " +
                        "phoneNumber, emailAddress) values (?, ?, ?, ?)", contact.getFirstName(),
                contact.getLastName(), contact.getPhoneNumber(), contact.getEmailAddress());

    }
}
