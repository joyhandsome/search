package com.wang.search.component;

import com.wang.search.constant.DocFormatConstant;
import com.wang.search.constant.ReturnCode;
import com.wang.search.core.DocumentEntity;
import com.wang.search.exception.DocException;

import java.io.File;
import java.io.InputStream;

/**
 * Word文档读取策略
 *
 * @author wangjunhao
 * @version 1.0
 * @date 2020/6/6 12:25
 * @since JDK 1.8
 */
public class DocReaderStrategy implements DocumentReaderStrategy{
    @Override
    public DocumentEntity read(byte[] file,String fileName) {
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());

        if (null == file) {
            throw new DocException(ReturnCode.DOCUMENT_NOT_FOUND);
        }
        if (DocFormatConstant.WORD_2003_SUFFIX.equals(suffix)) {

        } else if (DocFormatConstant.WORD_2007_SUFFIX.equals(suffix)) {

        }
        throw new DocException(ReturnCode.DOCUMENT_FORMAT_ERROR);
    }
}
