
package nc.itf.wsh.gztzd.gztzdmaster;

import java.util.Map;

import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;

import nc.vo.gztzd.gztzd.AggGztzdMasterVO;
import nc.vo.gztzd.gztzd.GztzdMasterVO;

public interface  IGztzdMasterVOService{

	/**
	 * ��װ������ʵ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public AggGztzdMasterVO[] listAggGztzdMasterVOByPk(String... pks) throws BusinessException;
	
	/**
	 * ��װ������ʵ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public AggGztzdMasterVO[] listAggGztzdMasterVOByPk(boolean blazyLoad,String... pks) throws BusinessException;
	
	/**
	 * ��װ������ʵ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk ����
	 * @return �������
	 */
	public  AggGztzdMasterVO findAggGztzdMasterVOByPk(String pk) throws BusinessException;
	
	/**
	 * ��װ������ʵ���AGGVO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  AggGztzdMasterVO[] listAggGztzdMasterVOByCondition(String condition) throws BusinessException;
	
	/**
	 * ��װ������ʵ���AGGVO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @param orderPath ���򼯺�
	 * @return �������
	 */
	public  AggGztzdMasterVO[] listAggGztzdMasterVOByCondition(String condition,String[] orderPath) throws BusinessException;
	
	/**
	 * ��װ������ʵ�������VO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public GztzdMasterVO[] listGztzdMasterVOByPk(String...pks) throws BusinessException;
	
	/**
	 * ��װ������ʵ�������VO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk ����
	 * @return �������
	 */
	public  GztzdMasterVO findGztzdMasterVOByPk(String pk) throws BusinessException;
	
	/**
	 * ��װ������ʵ�������VO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  GztzdMasterVO[] listGztzdMasterVOByCondition(String condition) throws BusinessException;
	/**
	 * ��װ������ʵ�������VO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  GztzdMasterVO[] listGztzdMasterVOByCondition(String condition,String[] orderPath) throws BusinessException;

	/**
	 * ��װ������ʵ�������pk��ѯ����
	 * ���������ַ�����ѯpk��������
	 * @param condition ��ѯ����+
	 * @return �������
	 */
	public String[] listGztzdMasterVOPkByCond(String condition) throws BusinessException;
	
	/**
	 * ��װ������ʵ�������pk��ѯ����
	 * ���������ַ�����ѯpk��������
	 * @param condition ��ѯ����+
	 * @return �������
	 */
	public String[] listGztzdMasterVOPkByCond(String condition,String[] orderPath) throws BusinessException;
	/**
	 * ����ʵ��vo����Ĭ��ֵ
	 * @param vo
	 */
	public void initDefaultData(GztzdMasterVO vo);
	
	
	/**
	 * Ԥ����������װ������ʵ������
	 * @param userJson  ����ʱ��Ҫ����չ��������
	 */
	public AggGztzdMasterVO preAddAggGztzdMasterVO(Map<String,Object> userJson) throws BusinessException;
	
	public AggGztzdMasterVO preAddAggGztzdMasterVO(AggGztzdMasterVO vo,Map<String,Object> userJson) throws BusinessException;
	 /**
	 * Ԥ�༭������װ������ʵ������
	 * @param userJson  ����ʱ��Ҫ����չ��������
	 */
	public AggGztzdMasterVO preEditAggGztzdMasterVO(String pk) throws BusinessException;
	
	 /**
	 * ���Ʋ�����װ������ʵ������
	 * 
	 */
	public AggGztzdMasterVO copyAggGztzdMasterVO(String pk) throws BusinessException;
	/**
	 * ���������װ������ʵ������
	 * @param vos �������
	 * @return @
	 */
	public AggGztzdMasterVO[] saveAggGztzdMasterVO(AggGztzdMasterVO vo) throws BusinessException;

	public AggGztzdMasterVO[] saveAggGztzdMasterVO(AggGztzdMasterVO[] vos) throws BusinessException;
	
	
	/**
	 * ɾ��������װ������ʵ������
	 * @param vos ɾ������
	 * @return @
	 */
	public AggGztzdMasterVO[] deleteAggGztzdMasterVOs(Map<String,String> tsMap) throws BusinessException;
	
	/**
	 * �������������ݹ�װ������ʵ��
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