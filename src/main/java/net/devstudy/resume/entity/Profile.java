package net.devstudy.resume.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import net.devstudy.resume.annotation.ProfileDataFieldGroup;
import net.devstudy.resume.annotation.constraints.Adulthood;
import net.devstudy.resume.annotation.constraints.EnglishLanguage;
import org.hibernate.validator.constraints.SafeHtml;
import org.joda.time.LocalDate;
import org.joda.time.Years;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Document(indexName="profile")
@org.springframework.data.mongodb.core.mapping.Document(collection="profile")
public class Profile {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String firstName;

    private String lastName;

    @Indexed(unique=true)
    private String uid;

    @ProfileDataFieldGroup
    @Adulthood
    @NotNull
    private Date birthDay;

    @ProfileDataFieldGroup
    @Size(max=100)
    @NotNull
    @SafeHtml
    @EnglishLanguage(withNumbers=false, withSpechSymbols=false)
    private String phone;

    @ProfileDataFieldGroup
    @Size(max=100)
    @NotNull
    @SafeHtml
    @EnglishLanguage(withNumbers=false, withSpechSymbols=false)
    private String email;

    @ProfileDataFieldGroup
    @Size(max=60)
    @NotNull
    @SafeHtml
    @EnglishLanguage(withNumbers=false, withSpechSymbols=false)
    private String country;

    @ProfileDataFieldGroup
    @Size(max=100)
    @NotNull
    @SafeHtml
    @EnglishLanguage(withNumbers=false, withSpechSymbols=false)
    private String city;

    @ProfileDataFieldGroup
    @NotNull
    @SafeHtml
    @EnglishLanguage
    private String objective;

    @ProfileDataFieldGroup
    @NotNull
    @SafeHtml
    @EnglishLanguage(withNumbers=false, withSpechSymbols=false)
    private String summary;

    @JsonIgnore
    @Size(max=255)
    private String largePhoto;

    @Size(max=255)
    private String smallPhoto;

    @ProfileDataFieldGroup
    @Size(max=100)
    @NotNull
    @SafeHtml
    @EnglishLanguage(withNumbers=false, withSpechSymbols=false)
    private String info;

    @ProfileDataFieldGroup
    @Size(max=100)
    @NotNull
    @SafeHtml
    @EnglishLanguage(withNumbers=false, withSpechSymbols=false)
    private String password;

    @JsonIgnore
    @Indexed
    boolean completed;

    @Indexed
    private Date created;

    private List<Certificate> certificates;

    @JsonIgnore
    private List<Education> educations;

    @JsonIgnore
    private List<Hobby> hobbies;

    private List<Language> languages;

    private List<Practic> practics;

    private List<Skill> skills;

    private List<Course> courses;

    @JsonIgnore
    private Contacts contacts;

    public Profile() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getLargePhoto() {
        return largePhoto;
    }

    public void setLargePhoto(String largePhoto) {
        this.largePhoto = largePhoto;
    }

    public String getSmallPhoto() {
        return smallPhoto;
    }

    public void setSmallPhoto(String smallPhoto) {
        this.smallPhoto = smallPhoto;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public List<Practic> getPractics() {
        return practics;
    }

    public void setPractics(List<Practic> practics) {
        this.practics = practics;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public int getAge(){
        LocalDate birthdate = new LocalDate (birthDay);
        LocalDate now = new LocalDate();
        Years age = Years.yearsBetween(birthdate, now);
        return age.getYears();
    }

    public String getProfilePhoto(){
        if(largePhoto != null) {
            return largePhoto;
        } else {
            return "/static/img/profile-placeholder.png";
        }
    }

    public void updateProfilePhotos(String largePhoto, String smallPhoto) {
        setLargePhoto(largePhoto);
        setSmallPhoto(smallPhoto);
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Contacts getContacts() {
        if(contacts == null) {
            contacts = new Contacts();
        }
        return contacts;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }
}
