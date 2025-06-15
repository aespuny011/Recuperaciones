package DTO;

public class Libro {
    private int id;
    private String titulo;
    private int anio;
    private Autor autor;

    public Libro(int id, String titulo, int anio, Autor autor) {
        this.id = id;
        this.titulo = titulo;
        this.anio = anio;
        this.autor = autor;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public int getAnio() { return anio; }
    public Autor getAutor() { return autor; }

    @Override
    public String toString() {
        return "Libro [ID=" + id + ", Título=" + titulo + ", Año=" + anio +
               ", Autor=" + autor.getNombre() + "]";
    }
}

