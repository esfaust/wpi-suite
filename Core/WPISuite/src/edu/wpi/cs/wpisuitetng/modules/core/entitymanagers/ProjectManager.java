package edu.wpi.cs.wpisuitetng.modules.core.entitymanagers;

import java.util.ArrayList;

import com.google.gson.Gson;

import edu.wpi.cs.wpisuitetng.core.DataStore;
import edu.wpi.cs.wpisuitetng.modules.EntityManager;
import edu.wpi.cs.wpisuitetng.modules.Model;
import edu.wpi.cs.wpisuitetng.modules.core.models.Project;
import edu.wpi.cs.wpisuitetng.modules.core.models.User;

public class ProjectManager implements EntityManager<Project>{

	Class<Project> project = Project.class;
	Gson gson;
	
	public ProjectManager()
	{
		gson = new Gson();
	}
	
	@Override
	public Project makeEntity(String content) {
		
		Project p;
		
		p = gson.fromJson(content, project);
		save(p);
		
		return p;
	}

	@Override
	public Project[] getEntity(String id) 
	{
		Model[] m = new Model[1];
		if(id.equalsIgnoreCase(""))
		{
			return getAll();
		}
		else
		{
			return (Project[]) DataStore.getDataStore().retrieve(project, "idNum", id).toArray(m);
		}
	}

	@Override
	public Project[] getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Project model) {
		DataStore.getDataStore().save(model);
		
	}

	@Override
	public void deleteEntity(String id) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int Count() {
		// TODO Auto-generated method stub
		return 0;
	}


	

}
