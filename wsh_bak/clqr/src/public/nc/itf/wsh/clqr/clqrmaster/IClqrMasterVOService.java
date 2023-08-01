
package nc.itf.wsh.clqr.clqrmaster;

import java.util.Map;

import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;

import nc.vo.clqr.clqr.AggClqrMasterVO;
import nc.vo.clqr.clqr.ClqrMasterVO;

public interface  IClqrMasterVOService{

	/**
	 * ����ȷ����ʵ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public AggClqrMasterVO[] listAggClqrMasterVOByPk(String... pks) throws BusinessException;
	
	/**
	 * ����ȷ����ʵ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public AggClqrMasterVO[] listAggClqrMasterVOByPk(boolean blazyLoad,String... pks) throws BusinessException;
	
	/**
	 * ����ȷ����ʵ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk ����
	 * @return �������
	 */
	public  AggClqrMasterVO findAggClqrMasterVOByPk(String pk) throws BusinessException;
	
	/**
	 * ����ȷ����ʵ���AGGVO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  AggClqrMasterVO[] listAggClqrMasterVOByCondition(String condition) throws BusinessException;
	
	/**
	 * ����ȷ����ʵ���AGGVO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @param orderPath ���򼯺�
	 * @return �������
	 */
	public  AggClqrMasterVO[] listAggClqrMasterVOByCondition(String condition,String[] orderPath) throws BusinessException;
	
	/**
	 * ����ȷ����ʵ�������VO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public ClqrMasterVO[] listClqrMasterVOByPk(String...pks) throws BusinessException;
	
	/**
	 * ����ȷ����ʵ�������VO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk ����
	 * @return �������
	 */
	public  ClqrMasterVO findClqrMasterVOByPk(String pk) throws BusinessException;
	
	/**
	 * ����ȷ����ʵ�������VO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  ClqrMasterVO[] listClqrMasterVOByCondition(String condition) throws BusinessException;
	/**
	 * ����ȷ����ʵ�������VO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  ClqrMasterVO[] listClqrMasterVOByCondition(String condition,String[] orderPath) throws BusinessException;

	/**
	 * ����ȷ����ʵ�������pk��ѯ����
	 * ���������ַ�����ѯpk��������
	 * @param condition ��ѯ����+
	 * @return �������
	 */
	public String[] listClqrMasterVOPkByCond(String condition) throws BusinessException;
	
	/**
	 * ����ȷ����ʵ�������pk��ѯ����
	 * ���������ַ�����ѯpk��������
	 * @param condition ��ѯ����+
	 * @return �������
	 */
	public String[] listClqrMasterVOPkByCond(String condition,String[] orderPath) throws BusinessException;
	/**
	 * ����ʵ��vo����Ĭ��ֵ
	 * @param vo
	 */
	public void initDefaultData(ClqrMasterVO vo);
	
	
	/**
	 * Ԥ������������ȷ����ʵ������
	 * @param userJson  ����ʱ��Ҫ����չ��������
	 */
	public AggClqrMasterVO preAddAggClqrMasterVO(Map<String,Object> userJson) throws BusinessException;
	
	public AggClqrMasterVO preAddAggClqrMasterVO(AggClqrMasterVO vo,Map<String,Object> userJson) throws BusinessException;
	 /**
	 * Ԥ�༭��������ȷ����ʵ������
	 * @param userJson  ����ʱ��Ҫ����չ��������
	 */
	public AggClqrMasterVO preEditAggClqrMasterVO(String pk) throws BusinessException;
	
	 /**
	 * ���Ʋ�������ȷ����ʵ������
	 * 
	 */
	public AggClqrMasterVO copyAggClqrMasterVO(String pk) throws BusinessException;
	/**
	 * �����������ȷ����ʵ������
	 * @param vos �������
	 * @return @
	 */
	public AggClqrMasterVO[] saveAggClqrMasterVO(AggClqrMasterVO vo) throws BusinessException;

	public AggClqrMasterVO[] saveAggClqrMasterVO(AggClqrMasterVO[] vos) throws BusinessException;
	
	
	/**
	 * ɾ����������ȷ����ʵ������
	 * @param vos ɾ������
	 * @return @
	 */
	public AggClqrMasterVO[] deleteAggClqrMasterVOs(Map<String,String> tsMap) throws BusinessException;
	
	/**
	 * �������������ݲ���ȷ����ʵ��
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