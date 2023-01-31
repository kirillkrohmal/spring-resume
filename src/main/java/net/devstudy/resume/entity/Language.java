package net.devstudy.resume.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import net.devstudy.resume.annotation.constraints.EnglishLanguage;
import net.devstudy.resume.model.LanguageType;
import org.hibernate.validator.constraints.SafeHtml;

import java.io.Serializable;

public class Language implements Serializable, ProfileEntity, Comparable<Language> {
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private LanguageType level;

    @SafeHtml
    @EnglishLanguage(withSpechSymbols=false, withNumbers=false, withPunctuations=false)
    private String name;

    private LanguageType type;


    public Language() {
    }

    public LanguageType getLevel() {
        return level;
    }

    public void setLevel(LanguageType level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LanguageType getType() {
        return type;
    }

    public void setType(LanguageType type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((level == null) ? 0 : level.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (!(obj instanceof Language))
            return false;
        Language other = (Language) obj;
        if (level == null) {
            if (other.level != null)
                return false;
        } else if (!level.equals(other.level))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (type != other.type)
            return false;
        return true;
    }

    @Override
    public int compareTo(Language o) {
        return getName().compareToIgnoreCase(o.getName());
    }
}
