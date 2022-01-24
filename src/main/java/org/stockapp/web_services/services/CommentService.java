package org.stockapp.web_services.services;

/*import java.util.ArrayList;
import java.util.List;*/
import java.util.Map;

import org.stockapp.web_services.database.Database;
import org.stockapp.web_services.model.Comment;
import org.stockapp.web_services.model.Message;

public class CommentService {
	
	private Map<Long, Message> messages = Database.getMessages();
	
	public Message getAllComments(Long messageId){
		//return new ArrayList<Comment>(messages.get(messageId).getComments().values());
		Message message = messages.get(messageId);
		//Map<Long, Comment> comments = message.getComments();
		return message;
	}
	
	public Comment getComment(Long messageId, Long commentId) {
		return messages.get(messageId).getComments().get(commentId);
	}
	
	public Comment addComment(Message message, Comment comment) {
		if(message.getId() > 0) {
			return null;
		}
		
		comment.setId(1L);
		comment.setMessage(message);
		return message.addComment(comment);
	}
	
	public Comment updateComment(Long messageId, Comment comment) {
		if(messageId > 0) {
			return null;
		}
		messages.get(messageId).getComments().replace(comment.getId(), comment);
		return comment;
	}
	
	public Comment removeComment(Long messageId, Long commentId) {
		return messages.get(messageId).getComments().remove(commentId);
	}
}
