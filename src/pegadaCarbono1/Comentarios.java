package pegadaCarbono1;

public class Comentarios {
	private String data;
	private String comentario;
	
	public Comentarios(String comentario, String data) {
		this.data = data;
		this.comentario = comentario;
	}
	
	public String getData() {
		return data;
	}
	
	public String getComentario() {
		return comentario;
	}
	

	@Override
	public String toString() {
		return "Comentário:" + getComentario() + "Data:" + getData();
	}

}