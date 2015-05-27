package pdigital.pactera.com.au.vote.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * The domain object for mobile device
 */

@Entity
@Table(name = "comment_category")
public class CommentCategory {


	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "commentCategory")
	private List<VoteComment> voteComments = new ArrayList<>();

	@Id
	@Column(name = "category_id")
	private String categoryId;

	public List<VoteComment> getVoteComments() {
		return voteComments;
	}

	public void setVoteComments(List<VoteComment> voteComments) {
		this.voteComments = voteComments;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
}



