/*
 * Copyright (C) July 2014 Rafael Aznar
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package net.daw.operation;

import java.sql.Connection;
import javax.servlet.ServletException;
import net.daw.bean.DocumentoBean;
import net.daw.dao.DocumentoDao;

public class DocumentoOperation extends GenericOperationImpl {

    public DocumentoOperation(Connection con) {
        super("Documento", con);
    }

    public String getContenido(Integer id) throws Exception {
        String data;
        try {
            DocumentoBean oDocumentoBean = new DocumentoBean();
            oDocumentoBean.setId(id);
            DocumentoDao oDocumentoDao = new DocumentoDao(oConnection);
            oDocumentoBean = oDocumentoDao.get(oDocumentoBean);
            return "{\"data\":\"" + oDocumentoBean.getContenido() + "\"}";
        } catch (Exception e) {
            throw new ServletException("GetContenido: View Error: " + e.getMessage());
        }
    }
}