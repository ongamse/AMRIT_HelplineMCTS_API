package com.iemr.mcts.services.supervisor;

import static org.mockito.Mockito.doReturn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.iemr.mcts.data.supervisor.FileManager;
import com.iemr.mcts.repository.supervisor.FileManagerRepository;


@RunWith(MockitoJUnitRunner.class)
public class UploadExcelServiceImplTest {
	
	@InjectMocks
	UploadExcelServiceImpl uploadExcelServiceImpl;
	
	@Mock
	FileManagerRepository fileManagerRepository;
	
	@Test
	public void saveFile()
	{
		FileManager fileManager=new FileManager();
		fileManager.setFileID(new Long(101));
		doReturn(fileManager).when(fileManagerRepository).save(Mockito.mock(FileManager.class));
		FileManager file=uploadExcelServiceImpl.saveFile(Mockito.any());
		
	}
}
