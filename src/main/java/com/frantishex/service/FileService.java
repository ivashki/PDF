package com.frantishex.service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.frantishex.model.DBFile;

@Service
@Transactional
public class FileService {
	@Autowired
	private EntityManager em;

	public DBFile storeFile(MultipartFile file) throws Exception {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		DBFile dbFile = new DBFile(fileName, file.getContentType(), file.getBytes());
		em.persist(dbFile);
		return dbFile;

	}

	public DBFile getFile(String fileId) {
		return em.find(DBFile.class, fileId);
	}

}
