
package nc.itf.wsh.zkdwx.zkdwxmaster;

import java.util.Map;

import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;

import nc.vo.zkdwx.zkdwx.AggZkdwxMasterVO;
import nc.vo.zkdwx.zkdwx.ZkdwxMasterVO;

public interface  IZkdwxMasterVOService{

	/**
	 * ת�ⵥ��ʵ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public AggZkdwxMasterVO[] listAggZkdwxMasterVOByPk(String... pks) throws BusinessException;
	
	/**
	 * ת�ⵥ��ʵ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public AggZkdwxMasterVO[] listAggZkdwxMasterVOByPk(boolean blazyLoad,String... pks) throws BusinessException;
	
	/**
	 * ת�ⵥ��ʵ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk ����
	 * @return �������
	 */
	public  AggZkdwxMasterVO findAggZkdwxMasterVOByPk(String pk) throws BusinessException;
	
	/**
	 * ת�ⵥ��ʵ���AGGVO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  AggZkdwxMasterVO[] listAggZkdwxMasterVOByCondition(String condition) throws BusinessException;
	
	/**
	 * ת�ⵥ��ʵ���AGGVO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @param orderPath ���򼯺�
	 * @return �������
	 */
	public  AggZkdwxMasterVO[] listAggZkdwxMasterVOByCondition(String condition,String[] orderPath) throws BusinessException;
	
	/**
	 * ת�ⵥ��ʵ�������VO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public ZkdwxMasterVO[] listZkdwxMasterVOByPk(String...pks) throws BusinessException;
	
	/**
	 * ת�ⵥ��ʵ�������VO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk ����
	 * @return �������
	 */
	public  ZkdwxMasterVO findZkdwxMasterVOByPk(String pk) throws BusinessException;
	
	/**
	 * ת�ⵥ��ʵ�������VO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  ZkdwxMasterVO[] listZkdwxMasterVOByCondition(String condition) throws BusinessException;
	/**
	 * ת�ⵥ��ʵ�������VO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  ZkdwxMasterVO[] listZkdwxMasterVOByCondition(String condition,String[] orderPath) throws BusinessException;

	/**
	 * ת�ⵥ��ʵ�������pk��ѯ����
	 * ���������ַ�����ѯpk��������
	 * @param condition ��ѯ����+
	 * @return �������
	 */
	public String[] listZkdwxMasterVOPkByCond(String condition) throws BusinessException;
	
	/**
	 * ת�ⵥ��ʵ�������pk��ѯ����
	 * ���������ַ�����ѯpk��������
	 * @param condition ��ѯ����+
	 * @return �������
	 */
	public String[] listZkdwxMasterVOPkByCond(String condition,String[] orderPath) throws BusinessException;
	/**
	 * ����ʵ��vo����Ĭ��ֵ
	 * @param vo
	 */
	public void initDefaultData(ZkdwxMasterVO vo);
	
	
	/**
	 * Ԥ��������ת�ⵥ��ʵ������
	 * @param userJson  ����ʱ��Ҫ����չ��������
	 */
	public AggZkdwxMasterVO preAddAggZkdwxMasterVO(Map<String,Object> userJson) throws BusinessException;
	
	public AggZkdwxMasterVO preAddAggZkdwxMasterVO(AggZkdwxMasterVO vo,Map<String,Object> userJson) throws BusinessException;
	 /**
	 * Ԥ�༭����ת�ⵥ��ʵ������
	 * @param userJson  ����ʱ��Ҫ����չ��������
	 */
	public AggZkdwxMasterVO preEditAggZkdwxMasterVO(String pk) throws BusinessException;
	
	 /**
	 * ���Ʋ���ת�ⵥ��ʵ������
	 * 
	 */
	public AggZkdwxMasterVO copyAggZkdwxMasterVO(String pk) throws BusinessException;
	/**
	 * �������ת�ⵥ��ʵ������
	 * @param vos �������
	 * @return @
	 */
	public AggZkdwxMasterVO[] saveAggZkdwxMasterVO(AggZkdwxMasterVO vo) throws BusinessException;

	public AggZkdwxMasterVO[] saveAggZkdwxMasterVO(AggZkdwxMasterVO[] vos) throws BusinessException;
	
	
	/**
	 * ɾ������ת�ⵥ��ʵ������
	 * @param vos ɾ������
	 * @return @
	 */
	public AggZkdwxMasterVO[] deleteAggZkdwxMasterVOs(Map<String,String> tsMap) throws BusinessException;
	
	/**
	 * ��������������ת�ⵥ��ʵ��
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