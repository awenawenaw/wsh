
package nc.itf.wsh.scll.scllmaster;

import java.util.Map;

import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;

import nc.vo.scll.scll.AggScllMasterVO;
import nc.vo.scll.scll.ScllMasterVO;

public interface  IScllMasterVOService{

	/**
	 * ����������ʵ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public AggScllMasterVO[] listAggScllMasterVOByPk(String... pks) throws BusinessException;
	
	/**
	 * ����������ʵ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public AggScllMasterVO[] listAggScllMasterVOByPk(boolean blazyLoad,String... pks) throws BusinessException;
	
	/**
	 * ����������ʵ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk ����
	 * @return �������
	 */
	public  AggScllMasterVO findAggScllMasterVOByPk(String pk) throws BusinessException;
	
	/**
	 * ����������ʵ���AGGVO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  AggScllMasterVO[] listAggScllMasterVOByCondition(String condition) throws BusinessException;
	
	/**
	 * ����������ʵ���AGGVO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @param orderPath ���򼯺�
	 * @return �������
	 */
	public  AggScllMasterVO[] listAggScllMasterVOByCondition(String condition,String[] orderPath) throws BusinessException;
	
	/**
	 * ����������ʵ�������VO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public ScllMasterVO[] listScllMasterVOByPk(String...pks) throws BusinessException;
	
	/**
	 * ����������ʵ�������VO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk ����
	 * @return �������
	 */
	public  ScllMasterVO findScllMasterVOByPk(String pk) throws BusinessException;
	
	/**
	 * ����������ʵ�������VO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  ScllMasterVO[] listScllMasterVOByCondition(String condition) throws BusinessException;
	/**
	 * ����������ʵ�������VO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  ScllMasterVO[] listScllMasterVOByCondition(String condition,String[] orderPath) throws BusinessException;

	/**
	 * ����������ʵ�������pk��ѯ����
	 * ���������ַ�����ѯpk��������
	 * @param condition ��ѯ����+
	 * @return �������
	 */
	public String[] listScllMasterVOPkByCond(String condition) throws BusinessException;
	
	/**
	 * ����������ʵ�������pk��ѯ����
	 * ���������ַ�����ѯpk��������
	 * @param condition ��ѯ����+
	 * @return �������
	 */
	public String[] listScllMasterVOPkByCond(String condition,String[] orderPath) throws BusinessException;
	/**
	 * ����ʵ��vo����Ĭ��ֵ
	 * @param vo
	 */
	public void initDefaultData(ScllMasterVO vo);
	
	
	/**
	 * Ԥ������������������ʵ������
	 * @param userJson  ����ʱ��Ҫ����չ��������
	 */
	public AggScllMasterVO preAddAggScllMasterVO(Map<String,Object> userJson) throws BusinessException;
	
	public AggScllMasterVO preAddAggScllMasterVO(AggScllMasterVO vo,Map<String,Object> userJson) throws BusinessException;
	 /**
	 * Ԥ�༭��������������ʵ������
	 * @param userJson  ����ʱ��Ҫ����չ��������
	 */
	public AggScllMasterVO preEditAggScllMasterVO(String pk) throws BusinessException;
	
	 /**
	 * ���Ʋ�������������ʵ������
	 * 
	 */
	public AggScllMasterVO copyAggScllMasterVO(String pk) throws BusinessException;
	/**
	 * �����������������ʵ������
	 * @param vos �������
	 * @return @
	 */
	public AggScllMasterVO[] saveAggScllMasterVO(AggScllMasterVO vo) throws BusinessException;

	public AggScllMasterVO[] saveAggScllMasterVO(AggScllMasterVO[] vos) throws BusinessException;
	
	
	/**
	 * ɾ����������������ʵ������
	 * @param vos ɾ������
	 * @return @
	 */
	public AggScllMasterVO[] deleteAggScllMasterVOs(Map<String,String> tsMap) throws BusinessException;
	
	/**
	 * ������������������������ʵ��
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