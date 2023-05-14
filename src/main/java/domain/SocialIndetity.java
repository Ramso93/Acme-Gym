
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;

import org.hibernate.validator.constraints.URL;

@Entity
@Access(AccessType.PROPERTY)
public class SocialIndetity extends DomainEntity {

	//constructor

	//atributos
	private String	nick;
	private URL		link;
	private String	name;


	public String getNick() {
		return this.nick;
	}
	public void setNick(final String nick) {
		this.nick = nick;
	}

	public URL getLink() {
		return this.link;
	}
	public void setLink(final URL link) {
		this.link = link;
	}

	public String getName() {
		return this.name;
	}
	public void setName(final String name) {
		this.name = name;
	}

	//relacion
	//igual que Curriculum-Trainer, aqui no se pone nada
}
