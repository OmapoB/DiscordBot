package ru.omarov.commands.list;

public abstract class Command {
    private String text;
    private String description;

    public Command() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return text + ": " + description + "\n";
    }
}
