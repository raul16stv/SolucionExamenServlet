package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Consola;
import es.salesianos.model.Empresa;

public class ConsolaAssembler {

	public static Consola assembleUserFrom(HttpServletRequest req) {
		
		Consola consola = new Consola();
		String nombre = req.getParameter("nombre");
		String empresa = req.getParameter("empresa");
		consola.setNombre(nombre);
		consola.setEmpresa(empresa);

		return consola;
	}
}