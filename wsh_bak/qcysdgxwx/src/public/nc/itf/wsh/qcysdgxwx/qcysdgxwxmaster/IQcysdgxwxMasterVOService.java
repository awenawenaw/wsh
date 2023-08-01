
package nc.itf.wsh.qcysdgxwx.qcysdgxwxmaster;

import java.util.Map;

import nc.vo.pub.BusinessException;

import nc.vo.qcysdgxwx.qcysdgxwx.AggQcysdgxwxMasterVO;
import nc.vo.qcysdgxwx.qcysdgxwx.QcysdgxwxMasterVO;

public interface  IQcysdgxwxMasterVOService{

	/**
	 * �������յ���������Э����AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public AggQcysdgxwxMasterVO[] listAggQcysdgxwxMasterVOByPk(String... pks) throws BusinessException;
	
	/**
	 * �������յ���������Э����AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public AggQcysdgxwxMasterVO[] listAggQcysdgxwxMasterVOByPk(boolean blazyLoad,String... pks) throws BusinessException;
	
	/**
	 * �������յ���������Э����AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk ����
	 * @return �������
	 */
	public  AggQcysdgxwxMasterVO findAggQcysdgxwxMasterVOByPk(String pk) throws BusinessException;
	
	/**
	 * �������յ���������Э����AGGVO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  AggQcysdgxwxMasterVO[] listAggQcysdgxwxMasterVOByCondition(String condition) throws BusinessException;
	
	/**
	 * �������յ���������Э����AGGVO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @param orderPath ���򼯺�
	 * @return �������
	 */
	public  AggQcysdgxwxMasterVO[] listAggQcysdgxwxMasterVOByCondition(String condition,String[] orderPath) throws BusinessException;
	
	/**
	 * �������յ���������Э��������VO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public QcysdgxwxMasterVO[] listQcysdgxwxMasterVOByPk(String...pks) throws BusinessException;
	
	/**
	 * �������յ���������Э��������VO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk ����
	 * @return �������
	 */
	public  QcysdgxwxMasterVO findQcysdgxwxMasterVOByPk(String pk) throws BusinessException;
	
	/**
	 * �������յ���������Э��������VO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  QcysdgxwxMasterVO[] listQcysdgxwxMasterVOByCondition(String condition) throws BusinessException;
	/**
	 * �������յ���������Э��������VO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  QcysdgxwxMasterVO[] listQcysdgxwxMasterVOByCondition(String condition,String[] orderPath) throws BusinessException;

	/**
	 * �������յ���������Э��������pk��ѯ����
	 * ���������ַ�����ѯpk��������
	 * @param condition ��ѯ����+
	 * @return �������
	 */
	public String[] listQcysdgxwxMasterVOPkByCond(String condition) throws BusinessException;
	
	/**
	 * �������յ���������Э��������pk��ѯ����
	 * ���������ַ�����ѯpk��������
	 * @param condition ��ѯ����+
	 * @return �������
	 */
	public String[] listQcysdgxwxMasterVOPkByCond(String condition,String[] orderPath) throws BusinessException;
	/**
	 * ����ʵ��vo����Ĭ��ֵ
	 * @param vo
	 */
	public void initDefaultData(QcysdgxwxMasterVO vo);
	
	
	/**
	 * Ԥ���������������յ���������Э������
	 * @param userJson  ����ʱ��Ҫ����չ��������
	 */
	public AggQcysdgxwxMasterVO preAddAggQcysdgxwxMasterVO(Map<String,Object> userJson) throws BusinessException;
	
	public AggQcysdgxwxMasterVO preAddAggQcysdgxwxMasterVO(AggQcysdgxwxMasterVO vo,Map<String,Object> userJson) throws BusinessException;
	 /**
	 * Ԥ�༭�����������յ���������Э������
	 * @param userJson  ����ʱ��Ҫ����չ��������
	 */
	public AggQcysdgxwxMasterVO preEditAggQcysdgxwxMasterVO(String pk) throws BusinessException;
	
	 /**
	 * ���Ʋ����������յ���������Э������
	 * 
	 */
	public AggQcysdgxwxMasterVO copyAggQcysdgxwxMasterVO(String pk) throws BusinessException;
	/**
	 * ��������������յ���������Э������
	 * @param vos �������
	 * @return @
	 */
	public AggQcysdgxwxMasterVO[] saveAggQcysdgxwxMasterVO(AggQcysdgxwxMasterVO vo) throws BusinessException;

	public AggQcysdgxwxMasterVO[] saveAggQcysdgxwxMasterVO(AggQcysdgxwxMasterVO[] vos) throws BusinessException;
	
	
	/**
	 * ɾ�������������յ���������Э������
	 * @param vos ɾ������
	 * @return @
	 */
	public AggQcysdgxwxMasterVO[] deleteAggQcysdgxwxMasterVOs(Map<String,String> tsMap) throws BusinessException;
	
	/**
	 * ���������������������յ���������Э��
	 * @param vos ����
	 * @return @
	 */
	public <T> T[] loadTreeData(Class<T> clazz,Map<String,Object> userJson) throws BusinessException;


}