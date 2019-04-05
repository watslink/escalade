package com.sd.oc.DAO.DAOImpl;

import com.sd.oc.DAO.DAOInterface.DepartementDAO;
import com.sd.oc.model.Departement;
import org.springframework.stereotype.Repository;

@Repository
public class DepartementDAOImpl extends GenericDAOImpl<Departement, String> implements DepartementDAO {
}
