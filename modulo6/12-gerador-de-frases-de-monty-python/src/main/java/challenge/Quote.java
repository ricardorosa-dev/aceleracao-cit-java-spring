package challenge;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "scripts")
public class Quote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer episode;
	
	@Column(name = "episode_name")
	private String episodeName;
	private String segment;
	private String type;
	private String actor;
	private String character;
	
	@Column(name = "detail", length = 10000)
	private String quote;
	
	@Column(name = "record_date")
	@CreatedDate
	private Timestamp recordDate;
	private String series;
	
	@Column(name = "transmission_date")
	@CreatedDate
	private Timestamp transmissionDate;
	

	public Quote(Integer episode, String episodeName, String segment, String type, String actor, String character,
			String detail, Timestamp recordDate, String series, Timestamp transmissionDate, String quote) {
		super();
		this.episode = episode;
		this.episodeName = episodeName;
		this.segment = segment;
		this.type = type;
		this.actor = actor;
		this.character = character;
		this.recordDate = recordDate;
		this.series = series;
		this.transmissionDate = transmissionDate;
		this.quote = quote;
	}

	public Quote(Integer id, String actor, String quote) {
		super();
		this.id = id;
		this.actor = actor;
		this.quote = quote;
	}
	
	// Nao vou usar o Lombok

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEpisode() {
		return episode;
	}

	public void setEpisode(Integer episode) {
		this.episode = episode;
	}

	public String getEpisodeName() {
		return episodeName;
	}

	public void setEpisodeName(String episodeName) {
		this.episodeName = episodeName;
	}

	public String getSegment() {
		return segment;
	}

	public void setSegment(String segment) {
		this.segment = segment;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public Timestamp getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Timestamp recordDate) {
		this.recordDate = recordDate;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public Timestamp getTransmissionDate() {
		return transmissionDate;
	}

	public void setTransmissionDate(Timestamp transmissionDate) {
		this.transmissionDate = transmissionDate;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	@Override
	public String toString() {
		return "Quote [id=" + id + ", episode=" + episode + ", episodeName=" + episodeName + ", segment=" + segment
				+ ", type=" + type + ", actor=" + actor + ", character=" + character + ", detail=" + ", recordDate=" + recordDate + ", series=" + series + ", transmissionDate=" + transmissionDate
				+ ", quote=" + quote + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(actor, character, episode, episodeName, id, quote, recordDate, segment, series,
				transmissionDate, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quote other = (Quote) obj;
		return Objects.equals(actor, other.actor) && Objects.equals(character, other.character)
				&& Objects.equals(episodeName, other.episodeName) && Objects.equals(id, other.id)
				&& Objects.equals(quote, other.quote) && Objects.equals(recordDate, other.recordDate)
				&& Objects.equals(segment, other.segment) && Objects.equals(series, other.series)
				&& Objects.equals(transmissionDate, other.transmissionDate) && Objects.equals(type, other.type);
	}

	public Quote() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Quote(Integer id, Integer episode, String episodeName, String segment, String type, String actor,
			String character, String detail, Timestamp recordDate, String series, Timestamp transmissionDate,
			String quote) {
		super();
		this.id = id;
		this.episode = episode;
		this.episodeName = episodeName;
		this.segment = segment;
		this.type = type;
		this.actor = actor;
		this.character = character;
		this.recordDate = recordDate;
		this.series = series;
		this.transmissionDate = transmissionDate;
		this.quote = quote;
	}
	
	
	
	
	
	

}

