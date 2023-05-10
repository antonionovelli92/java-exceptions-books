package books;

public class Libro {
    private String titolo;
    private int numPagine;
    private String autore;
    private String editore;

    public Libro(String titolo, int numPagine, String autore, String editore) throws Exception {
    	
    	setTitolo(titolo);
    	setNumPagine(numPagine);
    	setAutore(autore);
    	setEditore(editore);
       
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) throws Exception {
        if (titolo == null || titolo.isEmpty()) {
            throw new Exception("Il titolo non può essere vuoto");
        }
        this.titolo = titolo;
    }

    public int getNumPagine() {
        return numPagine;
    }

    public void setNumPagine(int numPagine) throws Exception {
        if (numPagine <= 0) {
            throw new Exception("Il numero di pagine deve essere maggiore di zero");
        }
        this.numPagine = numPagine;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) throws Exception {
        if (autore == null || autore.isEmpty()) {
            throw new Exception("L'autore non può essere vuoto");
        }
        this.autore = autore;
    }

    public String getEditore() {
        return editore;
    }

    public void setEditore(String editore) {
        this.editore = editore;
    }
}
