package org.terems.webz;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Map;
import java.util.Properties;

import org.terems.webz.cache.WebzFileSystemCache;

/** TODO !!! describe !!! **/
public interface WebzFileSystem extends WebzDestroyable {

	// TODO rename pathName to pathname everywhere !

	/** TODO !!! describe !!! **/
	public void init(Properties properties) throws WebzException;

	/** TODO !!! describe !!! **/
	public String getFileSystemUniqueId();

	/** TODO !!! describe !!! **/
	public String normalizePathName(String nonNormalizedPathName);

	/** TODO !!! describe !!! **/
	public boolean isNormalizedPathNameInvalid(String pathName);

	/** TODO !!! describe !!! **/
	public String getParentPathName(String pathName);

	/** TODO !!! describe !!! **/
	public String concatPathName(String basePathName, String relativePathName);

	/** TODO !!! describe !!! **/
	public void inflate(WebzFile file) throws IOException, WebzException;

	/** TODO !!! describe !!! **/
	public void inflate(WebzFileSystemCache fileSystemCache, WebzFile file) throws IOException, WebzException;

	/** TODO !!! describe !!! **/
	public WebzMetadata getMetadata(String pathName) throws IOException, WebzException;

	/** TODO !!! describe !!! **/
	public ParentChildrenMetadata getParentChildrenMetadata(String parentPathName) throws IOException, WebzException;

	/**
	 * @return null if folder hash has not changed, otherwise - FreshParentChildrenMetadata object that encapsulates ParentChildrenMetadata;
	 *         however encapsulated ParentChildrenMetadata may be null if there is no such file or folder...
	 **/
	public FreshParentChildrenMetadata getParentChildrenMetadataIfChanged(String parentPathName, Object previousFolderHash)
			throws IOException, WebzException;

	/** TODO !!! describe !!! **/
	public Map<String, WebzMetadata> getChildPathNamesAndMetadata(String parentPathName) throws IOException, WebzException;

	/** TODO !!! describe !!! **/
	public Collection<String> getChildPathNames(String parentPathName) throws IOException, WebzException;

	/** TODO !!! describe !!! **/
	public WebzMetadata.FileSpecific copyContentToOutputStream(String pathName, OutputStream out) throws IOException, WebzException;

	/** TODO !!! describe !!! **/
	public WebzFileDownloader getFileDownloader(String pathName) throws IOException, WebzException;

	/** TODO !!! describe !!! **/
	public WebzMetadata createFolder(String pathName) throws IOException, WebzException;

	/** TODO !!! describe !!! **/
	public WebzMetadata.FileSpecific uploadFile(String pathName, InputStream content, long numBytes) throws IOException, WebzException;

	/** TODO !!! describe !!! **/
	public WebzMetadata.FileSpecific uploadFile(String pathName, InputStream content) throws IOException, WebzException;

	/** TODO !!! describe !!! **/
	public WebzMetadata move(String srcPathName, String destPathName) throws IOException, WebzException;

	/** TODO !!! describe !!! **/
	public WebzMetadata copy(String srcPathName, String destPathName) throws IOException, WebzException;

	/** TODO !!! describe !!! **/
	public void delete(String pathName) throws IOException, WebzException;

}
