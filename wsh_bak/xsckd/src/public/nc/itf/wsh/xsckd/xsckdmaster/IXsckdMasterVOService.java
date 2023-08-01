
package nc.itf.wsh.xsckd.xsckdmaster;

import java.util.Map;

import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;

import nc.vo.wsh.xsckd.AggXsckdMasterVO;
import nc.vo.wsh.xsckd.XsckdMasterVO;

public interface  IXsckdMasterVOService{

	/**
	 * ���ⵥʵ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public AggXsckdMasterVO[] listAggXsckdMasterVOByPk(String... pks) throws BusinessException;
	
	/**
	 * ���ⵥʵ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public AggXsckdMasterVO[] listAggXsckdMasterVOByPk(boolean blazyLoad,String... pks) throws BusinessException;
	
	/**
	 * ���ⵥʵ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk ����
	 * @return �������
	 */
	public  AggXsckdMasterVO findAggXsckdMasterVOByPk(String pk) throws BusinessException;
	
	/**
	 * ���ⵥʵ���AGGVO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  AggXsckdMasterVO[] listAggXsckdMasterVOByCondition(String condition) throws BusinessException;
	
	/**
	 * ���ⵥʵ���AGGVO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @param orderPath ���򼯺�
	 * @return �������
	 */
	public  AggXsckdMasterVO[] listAggXsckdMasterVOByCondition(String condition,String[] orderPath) throws BusinessException;
	
	/**
	 * ���ⵥʵ�������VO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public XsckdMasterVO[] listXsckdMasterVOByPk(String...pks) throws BusinessException;
	
	/**
	 * ���ⵥʵ�������VO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk ����
	 * @return �������
	 */
	public  XsckdMasterVO findXsckdMasterVOByPk(String pk) throws BusinessException;
	
	/**
	 * ���ⵥʵ�������VO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  XsckdMasterVO[] listXsckdMasterVOByCondition(String condition) throws BusinessException;
	/**
	 * ���ⵥʵ�������VO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  XsckdMasterVO[] listXsckdMasterVOByCondition(String condition,String[] orderPath) throws BusinessException;

	/**
	 * ���ⵥʵ�������pk��ѯ����
	 * ���������ַ�����ѯpk��������
	 * @param condition ��ѯ����+
	 * @return �������
	 */
	public String[] listXsckdMasterVOPkByCond(String condition) throws BusinessException;
	
	/**
	 * ���ⵥʵ�������pk��ѯ����
	 * ���������ַ�����ѯpk��������
	 * @param condition ��ѯ����+
	 * @return �������
	 */
	public String[] listXsckdMasterVOPkByCond(String condition,String[] orderPath) throws BusinessException;
	/**
	 * ����ʵ��vo����Ĭ��ֵ
	 * @param vo
	 */
	public void initDefaultData(XsckdMasterVO vo);
	
	
	/**
	 * Ԥ�����������ⵥʵ������
	 * @param userJson  ����ʱ��Ҫ����չ��������
	 */
	public AggXsckdMasterVO preAddAggXsckdMasterVO(Map<String,Object> userJson) throws BusinessException;
	
	public AggXsckdMasterVO preAddAggXsckdMasterVO(AggXsckdMasterVO vo,Map<String,Object> userJson) throws BusinessException;
	 /**
	 * Ԥ�༭�������ⵥʵ������
	 * @param userJson  ����ʱ��Ҫ����չ��������
	 */
	public AggXsckdMasterVO preEditAggXsckdMasterVO(String pk) throws BusinessException;
	
	 /**
	 * ���Ʋ������ⵥʵ������
	 * 
	 */
	public AggXsckdMasterVO copyAggXsckdMasterVO(String pk) throws BusinessException;
	/**
	 * ����������ⵥʵ������
	 * @param vos �������
	 * @return @
	 */
	public AggXsckdMasterVO[] saveAggXsckdMasterVO(AggXsckdMasterVO vo) throws BusinessException;

	public AggXsckdMasterVO[] saveAggXsckdMasterVO(AggXsckdMasterVO[] vos) throws BusinessException;
	
	
	/**
	 * ɾ���������ⵥʵ������
	 * @param vos ɾ������
	 * @return @
	 */
	public AggXsckdMasterVO[] deleteAggXsckdMasterVOs(Map<String,String> tsMap) throws BusinessException;
	
	/**
	 * �������������ݳ��ⵥʵ��
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