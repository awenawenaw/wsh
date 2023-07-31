
package nc.itf.wsh.dbckd.dbckdmaster;

import java.util.Map;

import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;

import nc.vo.dbckd.dbckd.AggDbckdMasterVO;
import nc.vo.dbckd.dbckd.DbckdMasterVO;

public interface  IDbckdMasterVOService{

	/**
	 * ��ʵ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public AggDbckdMasterVO[] listAggDbckdMasterVOByPk(String... pks) throws BusinessException;
	
	/**
	 * ��ʵ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public AggDbckdMasterVO[] listAggDbckdMasterVOByPk(boolean blazyLoad,String... pks) throws BusinessException;
	
	/**
	 * ��ʵ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk ����
	 * @return �������
	 */
	public  AggDbckdMasterVO findAggDbckdMasterVOByPk(String pk) throws BusinessException;
	
	/**
	 * ��ʵ���AGGVO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  AggDbckdMasterVO[] listAggDbckdMasterVOByCondition(String condition) throws BusinessException;
	
	/**
	 * ��ʵ���AGGVO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @param orderPath ���򼯺�
	 * @return �������
	 */
	public  AggDbckdMasterVO[] listAggDbckdMasterVOByCondition(String condition,String[] orderPath) throws BusinessException;
	
	/**
	 * ��ʵ�������VO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public DbckdMasterVO[] listDbckdMasterVOByPk(String...pks) throws BusinessException;
	
	/**
	 * ��ʵ�������VO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk ����
	 * @return �������
	 */
	public  DbckdMasterVO findDbckdMasterVOByPk(String pk) throws BusinessException;
	
	/**
	 * ��ʵ�������VO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  DbckdMasterVO[] listDbckdMasterVOByCondition(String condition) throws BusinessException;
	/**
	 * ��ʵ�������VO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  DbckdMasterVO[] listDbckdMasterVOByCondition(String condition,String[] orderPath) throws BusinessException;

	/**
	 * ��ʵ�������pk��ѯ����
	 * ���������ַ�����ѯpk��������
	 * @param condition ��ѯ����+
	 * @return �������
	 */
	public String[] listDbckdMasterVOPkByCond(String condition) throws BusinessException;
	
	/**
	 * ��ʵ�������pk��ѯ����
	 * ���������ַ�����ѯpk��������
	 * @param condition ��ѯ����+
	 * @return �������
	 */
	public String[] listDbckdMasterVOPkByCond(String condition,String[] orderPath) throws BusinessException;
	/**
	 * ����ʵ��vo����Ĭ��ֵ
	 * @param vo
	 */
	public void initDefaultData(DbckdMasterVO vo);
	
	
	/**
	 * Ԥ����������ʵ������
	 * @param userJson  ����ʱ��Ҫ����չ��������
	 */
	public AggDbckdMasterVO preAddAggDbckdMasterVO(Map<String,Object> userJson) throws BusinessException;
	
	public AggDbckdMasterVO preAddAggDbckdMasterVO(AggDbckdMasterVO vo,Map<String,Object> userJson) throws BusinessException;
	 /**
	 * Ԥ�༭������ʵ������
	 * @param userJson  ����ʱ��Ҫ����չ��������
	 */
	public AggDbckdMasterVO preEditAggDbckdMasterVO(String pk) throws BusinessException;
	
	 /**
	 * ���Ʋ�����ʵ������
	 * 
	 */
	public AggDbckdMasterVO copyAggDbckdMasterVO(String pk) throws BusinessException;
	/**
	 * ���������ʵ������
	 * @param vos �������
	 * @return @
	 */
	public AggDbckdMasterVO[] saveAggDbckdMasterVO(AggDbckdMasterVO vo) throws BusinessException;

	public AggDbckdMasterVO[] saveAggDbckdMasterVO(AggDbckdMasterVO[] vos) throws BusinessException;
	
	
	/**
	 * ɾ��������ʵ������
	 * @param vos ɾ������
	 * @return @
	 */
	public AggDbckdMasterVO[] deleteAggDbckdMasterVOs(Map<String,String> tsMap) throws BusinessException;
	
	/**
	 * ����������������ʵ��
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