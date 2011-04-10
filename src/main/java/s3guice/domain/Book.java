package s3guice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@Entity
public class Book {
	@Id
	private int id;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String author;

	@Column
	private int publishYear;
}
