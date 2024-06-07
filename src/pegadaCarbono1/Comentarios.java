package pegadaCarbono1;

public class Comentarios {
	private String nome;
	private String data;
	private String comentario;
	
	public Comentarios(String nome, String data, String comentario) {
		this.nome = nome;
		this.data = data;
		this.comentario = comentario;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public String getComentario() {
		return comentario;
	}
	
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	@Override
	public String toString() {
		return "Nome:" + getNome() + ", Data:" + getData() + ", Comentário:" + getComentario();
	}

}