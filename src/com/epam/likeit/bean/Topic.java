package com.epam.likeit.bean;

import java.io.Serializable;

/**
 * Created by mts7072572 on 27.05.2017.
 */
public class Topic implements Serializable {
    private int idTopic;
    private String topicName;

    public Topic() {
    }

    public int getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(int idTopic) {
        this.idTopic = idTopic;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "idTopic=" + idTopic +
                ", topicName='" + topicName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Topic topic = (Topic) o;

        if (idTopic != topic.idTopic) return false;
        return topicName != null ? topicName.equals(topic.topicName) : topic.topicName == null;
    }

    @Override
    public int hashCode() {
        int result = idTopic;
        result = 31 * result + (topicName != null ? topicName.hashCode() : 0);
        return result;
    }
}
