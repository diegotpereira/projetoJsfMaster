package control;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import entity.Cliente;
import persistence.ClienteDao;



@ManagedBean(name = "mb")
@RequestScoped
public class ControlBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Cliente cliente;
	private List<Cliente> clientes;
	
	public List<Cliente>getClientes(){
		try {
			clientes = new ClienteDao().findAll();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return clientes;
	}
	public void setClientes(List<Cliente>clientes) {
		this.clientes = clientes;
	}
	
	{
		cliente = new Cliente();
	}
	public ControlBean() {}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public void gravar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			new ClienteDao().create(cliente);
			cliente = new Cliente();
			fc.addMessage("form1", new FacesMessage("Dados Gravados!!!"));
		} catch (Exception e) {
			// TODO: handle exception
			fc.addMessage("form1", new FacesMessage("Erro: " + e.getMessage()));
		}
	}
	public void excluir() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			new ClienteDao().delete(cliente.getId());
			cliente = new Cliente();
		} catch (Exception e) {
			// TODO: handle exception
			fc.addMessage("form2", new FacesMessage("Erro:" + e.getMessage()));
		}
	}
	public void alterar() {
		FacesContext fc= FacesContext.getCurrentInstance();
		try {
			new ClienteDao().update(cliente);
			cliente = new Cliente();
			fc.addMessage(null, new FacesMessage("Dados Alterados"));
		} catch (Exception e) {
			// TODO: handle exception
			fc.addMessage(null, new FacesMessage("Erro:" + e.getMessage()));
		}
	}

}
