package seedu.address.model.util;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.tag.EventTag;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        return new Person[] {
                new Person(new Name("Alex Yeoh"), new Phone("99999999"), new Email("alexyeoh@example.com"),
                        new Address("Blk 30 Geylang Street 29, #06-40"),
                        getTagSet("operations"),
                        getEventTagSet("Flag|Flag event|2024-04-10T18:00:00|2024-04-10T22:00:00")),
                new Person(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                        new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
                        getTagSet("marketing"),
                        getEventTagSet("Flag|Flag event|2024-04-10T18:00:00|2024-04-10T22:00:00")),
                new Person(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
                        new Address("Blk 11 Ang Mo Kio Street 74, #11-04"),
                        getTagSet("logistics"),
                        getEventTagSet("Rag|Rag event|2024-04-05T14:00:00|2024-04-05T16:00:00")),
                new Person(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
                        new Address("Blk 436 Serangoon Gardens Street 26, #16-43"),
                        getTagSet("publicity"),
                        getEventTagSet("Rag|Rag event|2024-04-05T14:00:00|2024-04-05T16:00:00")),
                new Person(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
                        new Address("Blk 47 Tampines Street 20, #17-35"),
                        getTagSet("publicity"),
                        getEventTagSet("Rag|Rag event|2024-04-05T14:00:00|2024-04-05T16:00:00")),
                new Person(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
                        new Address("Blk 45 Aljunied Street 85, #11-31"),
                        getTagSet("VPD"),
                        getEventTagSet("Rag|Rag event|2024-04-05T14:00:00|2024-04-05T16:00:00")),
                new Person(new Name("Tom Goh"), new Phone("91234812"), new Email("hi@mail.com"),
                        new Address("Blk 98 Telok Blangah Street 85, #11-09"),
                        getTagSet("secretary"),
                        getEventTagSet("Flag|Flag event|2024-04-10T18:00:00|2024-04-10T22:00:00")),
                new Person(new Name("John Tan"), new Phone("91232345"), new Email("john@john.com"),
                        new Address("Blk 1 Hougang Street 3, #07-18"),
                        getTagSet("operations"),
                        getEventTagSet("Flag|Flag event|2024-04-10T18:00:00|2024-04-10T22:00:00")),
                new Person(new Name("Ben Tan"), new Phone("83478596"), new Email("ben@mail.com"),
                        new Address("NA"),
                        getTagSet("operations"),
                        getEventTagSet("Flag|Flag event|2024-04-10T18:00:00|2024-04-10T22:00:00")),
                new Person(new Name("Ann Lee"), new Phone("82882919"), new Email("Ann@mail.com"),
                        new Address("NA"),
                        getTagSet("head", "publicity"),
                        getEventTagSet("Flag|Flag event|2024-04-10T18:00:00|2024-04-10T22:00:00")),
                new Person(new Name("Amy Lim"), new Phone("82882919"), new Email("Amy@mail.com"),
                        new Address("AMK Blk 91"),
                        getTagSet("head", "operations"),
                        getEventTagSet("Flag|Flag event|2024-04-10T18:00:00|2024-04-10T22:00:00")),
                new Person(new Name("Betty Ho"), new Phone("93882919"), new Email("Betty@mail.com"),
                        new Address("AMK Blk 10"),
                        getTagSet("logistics"),
                        getEventTagSet("Flag|Flag event|2024-04-10T18:00:00|2024-04-10T22:00:00")),
                new Person(new Name("Zack Goh"), new Phone("82820119"), new Email("zack@mail.com"),
                        new Address("AMK Blk 10"),
                        getTagSet("logistics"),
                        getEventTagSet("Flag|Flag event|2024-04-10T18:00:00|2024-04-10T22:00:00")),
                new Person(new Name("Xan"), new Phone("82882919"), new Email("xan@mail.com"),
                        new Address("Bishan Blk 10"),
                        getTagSet("logistics"),
                        getEventTagSet("Flag|Flag event|2024-04-10T18:00:00|2024-04-10T22:00:00")),
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

    /**
     * Returns a set of event tags containing the list of strings given.
     */
    public static Set<EventTag> getEventTagSet(String... strings) {
        Set<EventTag> eventTags = new HashSet<>();
        for (String s : strings) {
            // parse string to extract tag name, description, start date, and end date
            // eg. "tagName|description|startDate|endDate"
            String[] parts = s.split("\\|");
            String tagName = parts[0];
            String description = parts[1];
            LocalDateTime startDate = LocalDateTime.parse(parts[2]);
            LocalDateTime endDate = LocalDateTime.parse(parts[3]);

            eventTags.add(new EventTag(tagName, description, startDate, endDate));
        }
        return eventTags;
    }

}
