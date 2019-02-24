package io.java.springbootstarter.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import io.java.springbootstarter.beans.Topic;

@Service
public class TopicService {

	private List<Topic> topicList = new ArrayList<>(
			Arrays.asList(new Topic("Java", "Core Java", "Core Java Description"),
					new Topic("Spring", "SpringBoot", "SpringBoot Description"),
					new Topic("JavaScript", "JavaScript", "JavaScript Description")));

	public List<Topic> getAllTopics() {
		return topicList;
	}

	public void addTopic(Topic topic) {
		topicList.add(topic);
	}

	public Topic getTopicByID(String id) {
		return topicList.stream().filter(topic -> topic.getId().equalsIgnoreCase(id)).findFirst().get();
	}

	public void updateTopic(String id,
			Topic topic) {
		
		/* for (int i = 0; i < topicList.size(); i++) { 
			 Topic t = topicList.get(i); 
			 if(t.getId().equalsIgnoreCase(id)) { 
				 topicList.set(i, topic); 
			 }
		 }*/
						

		topicList.stream().filter(t -> t.getId().equalsIgnoreCase(id)).collect(Collectors.toList()).forEach(t1 -> {			
			t1.setDescription(topic.getDescription());
			t1.setName(topic.getName());
		});

	}

	public void deleteTopic(String id) {

		/*topicList.removeIf(topic -> topic.getId().equalsIgnoreCase(id));*/
		
		topicList.stream().filter(topic -> topic.getId().equalsIgnoreCase(id)).collect(Collectors.toList())
			.forEach(topic -> topicList.remove(topic));
		
	}

}
