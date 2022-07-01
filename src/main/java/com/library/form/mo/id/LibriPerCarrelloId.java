package com.library.form.mo.id;

import java.io.Serializable;

import com.library.form.mo.Carrello;
import com.library.form.mo.LibriPerCarrello;
import com.library.form.mo.Libro;

public class LibriPerCarrelloId implements Serializable{

	private static final long serialVersionUID = 6013010790221009381L;
	
	private Carrello carrello;
	private Libro libro;
	
	public LibriPerCarrelloId() {
		super();
		}
	
	public LibriPerCarrelloId(Carrello carrello, Libro libro) {
		super();
		this.carrello = carrello;
		this.libro = libro;
	}

	
	@Override
	public boolean equals(Object o) {

		if (o == this) return true;
        if (!(o instanceof LibriPerCarrello)) {
            return false;
        }

        LibriPerCarrello lpc = (LibriPerCarrello) o;

        return lpc.getCarrello().getId() == this.carrello.getId() &&
                lpc.getLibro().getIsbn().equals(this.libro.getIsbn());
	}
	
	@Override
	public int hashCode() {

		Integer result = 17;
		
		result = 31 * result + this.carrello.getId();
		result = 31 * result + this.libro.getIsbn().hashCode();
		
        return result;
	}
	
}
