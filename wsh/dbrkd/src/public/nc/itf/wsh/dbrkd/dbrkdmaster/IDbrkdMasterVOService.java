
package nc.itf.wsh.dbrkd.dbrkdmaster;

import java.util.Map;

import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;

import nc.vo.dbrkd.dbrkd.AggDbrkdMasterVO;
import nc.vo.dbrkd.dbrkd.DbrkdMasterVO;

public interface  IDbrkdMasterVOService{

	/**
	 * ������ⵥ��AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public AggDbrkdMasterVO[] listAggDbrkdMasterVOByPk(String... pks) throws BusinessException;
	
	/**
	 * ������ⵥ��AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public AggDbrkdMasterVO[] listAggDbrkdMasterVOByPk(boolean blazyLoad,String... pks) throws BusinessException;
	
	/**
	 * ������ⵥ��AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk ����
	 * @return �������
	 */
	public  AggDbrkdMasterVO findAggDbrkdMasterVOByPk(String pk) throws BusinessException;
	
	/**
	 * ������ⵥ��AGGVO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  AggDbrkdMasterVO[] listAggDbrkdMasterVOByCondition(String condition) throws BusinessException;
	
	/**
	 * ������ⵥ��AGGVO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @param orderPath ���򼯺�
	 * @return �������
	 */
	public  AggDbrkdMasterVO[] listAggDbrkdMasterVOByCondition(String condition,String[] orderPath) throws BusinessException;
	
	/**
	 * ������ⵥ������VO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public DbrkdMasterVO[] listDbrkdMasterVOByPk(String...pks) throws BusinessException;
	
	/**
	 * ������ⵥ������VO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk ����
	 * @return �������
	 */
	public  DbrkdMasterVO findDbrkdMasterVOByPk(String pk) throws BusinessException;
	
	/**
	 * ������ⵥ������VO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  DbrkdMasterVO[] listDbrkdMasterVOByCondition(String condition) throws BusinessException;
	/**
	 * ������ⵥ������VO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  DbrkdMasterVO[] listDbrkdMasterVOByCondition(String condition,String[] orderPath) throws BusinessException;

	/**
	 * ������ⵥ������pk��ѯ����
	 * ���������ַ�����ѯpk��������
	 * @param condition ��ѯ����+
	 * @return �������
	 */
	public String[] listDbrkdMasterVOPkByCond(String condition) throws BusinessException;
	
	/**
	 * ������ⵥ������pk��ѯ����
	 * ���������ַ�����ѯpk��������
	 * @param condition ��ѯ����+
	 * @return �������
	 */
	public String[] listDbrkdMasterVOPkByCond(String condition,String[] orderPath) throws BusinessException;
	/**
	 * ����ʵ��vo����Ĭ��ֵ
	 * @param vo
	 */
	public void initDefaultData(DbrkdMasterVO vo);
	
	
	/**
	 * Ԥ��������������ⵥ����
	 * @param userJson  ����ʱ��Ҫ����չ��������
	 */
	public AggDbrkdMasterVO preAddAggDbrkdMasterVO(Map<String,Object> userJson) throws BusinessException;
	
	public AggDbrkdMasterVO preAddAggDbrkdMasterVO(AggDbrkdMasterVO vo,Map<String,Object> userJson) throws BusinessException;
	 /**
	 * Ԥ�༭����������ⵥ����
	 * @param userJson  ����ʱ��Ҫ����չ��������
	 */
	public AggDbrkdMasterVO preEditAggDbrkdMasterVO(String pk) throws BusinessException;
	
	 /**
	 * ���Ʋ���������ⵥ����
	 * 
	 */
	public AggDbrkdMasterVO copyAggDbrkdMasterVO(String pk) throws BusinessException;
	/**
	 * �������������ⵥ����
	 * @param vos �������
	 * @return @
	 */
	public AggDbrkdMasterVO[] saveAggDbrkdMasterVO(AggDbrkdMasterVO vo) throws BusinessException;

	public AggDbrkdMasterVO[] saveAggDbrkdMasterVO(AggDbrkdMasterVO[] vos) throws BusinessException;
	
	
	/**
	 * ɾ������������ⵥ����
	 * @param vos ɾ������
	 * @return @
	 */
	public AggDbrkdMasterVO[] deleteAggDbrkdMasterVOs(Map<String,String> tsMap) throws BusinessException;
	
	/**
	 * �������������ݵ�����ⵥ
	 * @param vos ����
	 * @return @
	 */
	public <T> T[] loadTreeData(Class<T> clazz,Map<String,Object> userJson) throws BusinessException;

	/**
	 * ��������������ѯ�ӱ�pks
	 * @param childClazz �ӱ�class
	 * @param parentId ��������
	 * @return �ӱ�pks
	 * @throws BusinessException
	 */
	String[] queryChildPksByParentId(Class childClazz, String parentId) throws BusinessException;

	/**
	 * �����ӱ�������ѯ�ӱ�����
	 * @param childClazz �ӱ�class
	 * @param pks �ӱ�
	 * @return �ӱ�vos
	 * @throws BusinessException
	 */
	SuperVO[] queryChildVOByPks(Class childClazz, String[] pks) throws BusinessException;

}