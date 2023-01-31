package net.devstudy.resume.entity;

import net.devstudy.resume.annotation.constraints.EnglishLanguage;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.data.annotation.Transient;

import java.io.Serializable;

public class Hobby implements Serializable, Comparable<Hobby>, ProfileEntity{
    private static final long serialVersionUID = 1L;

    @SafeHtml
    @EnglishLanguage(withSpechSymbols = false)
    private String name;

    @Transient
    private boolean selected;

    public Hobby() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override
    public int compareTo(Hobby o) {
        return getName().compareTo(o.getName());
    }

    @Override
    public String toString() {
        return String.format("Hobby [name=%s]", name);
    }
}
