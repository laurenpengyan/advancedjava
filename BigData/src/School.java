public class School implements Comparable<School> {

    private long id;
    private String name;
    private String state;
    private long awards;
    private long recipients;

    public School(long id, String name, String state, long awards, long recipients) {
        this.id = id;
        this.awards = awards;
        this.recipients = recipients;
        this.name = name;
        this.state = state;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == this)
            return true;

        if (!(obj instanceof School)) {
            return false;
        }

        return this.id == ((School) obj).id;

    }

    @Override
    public int compareTo(School school) {

        if (school == this)
            return 0;

        return Long.compare(id, school.getId());
    }

    @Override
    public String toString() {
        return "School: " + name + "\n State: " + state + "\n Awards: " + awards + "\n Recipients: " + recipients;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public long getAwards() {
        return awards;
    }

    public long getRecipients() {
        return recipients;
    }

}
