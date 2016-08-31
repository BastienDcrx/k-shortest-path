import java.util.ArrayList;

public class Vertex {

	protected String _noeud;
	protected ArrayList<Vertex> _nexts;
	protected int _weight,_x,_y;
	protected boolean visited;
	
	public int get_x() {
		return _x;
	}
	public void set_x(int _x) {
		this._x = _x;
	}
	public int get_y() {
		return _y;
	}
	public void set_y(int _y) {
		this._y = _y;
	}
	public String get_noeud() {
		return _noeud;
	}
	public void set_noeud(String _noeud) {
		this._noeud = _noeud;
	}
	public ArrayList<Vertex> get_nexts() {
		return _nexts;
	}
	public void set_nexts(ArrayList<Vertex> _nexts) {
		this._nexts = _nexts;
	}
	public void set_next(Vertex _next){
		this._nexts.add(_next);
	}
	public int get_weight() {
		return _weight;
	}
	public void set_weight(int _weight) {
		this._weight = _weight;
	}

	public Vertex(String nom, int weight){
		this.set_weight(weight);
		this.set_noeud(nom);
	}
}
