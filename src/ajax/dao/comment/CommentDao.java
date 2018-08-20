package ajax.dao.comment;

import java.util.List;

import ajax.model.Comment;

public interface CommentDao {
	Comment selectByNum(int num);
	Comment insertAndResult(Comment comment);
	List<Comment> selectCommentAll();
	boolean insert(Comment comment);
	boolean delete(int num);
}
