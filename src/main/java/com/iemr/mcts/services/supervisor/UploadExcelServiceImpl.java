package com.iemr.mcts.services.supervisor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.mcts.data.supervisor.FileManager;
import com.iemr.mcts.repository.supervisor.FileManagerRepository;


@Service
public class UploadExcelServiceImpl implements UploadExcelService {

	
		@Override
		public FileManager saveFile(FileManager fileManager) {
			
			return fileManagerRepository.save(fileManager);
		}
		
		
		@Autowired
		private FileManagerRepository fileManagerRepository;

		
		
	}
	
	


