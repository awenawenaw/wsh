
package nc.itf.wsh.qtcksq.qtcksqmaster;

import java.util.Map;

import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;

import nc.vo.qtcksq.qtcksq.AggQtcksqMasterVO;
import nc.vo.qtcksq.qtcksq.QtcksqMasterVO;

public interface  IQtcksqMasterVOService{

	/**
	 * ��������������ʵ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public AggQtcksqMasterVO[] listAggQtcksqMasterVOByPk(String... pks) throws BusinessException;
	
	/**
	 * ��������������ʵ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public AggQtcksqMasterVO[] listAggQtcksqMasterVOByPk(boolean blazyLoad,String... pks) throws BusinessException;
	
	/**
	 * ��������������ʵ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk ����
	 * @return �������
	 */
	public  AggQtcksqMasterVO findAggQtcksqMasterVOByPk(String pk) throws BusinessException;
	
	/**
	 * ��������������ʵ���AGGVO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  AggQtcksqMasterVO[] listAggQtcksqMasterVOByCondition(String condition) throws BusinessException;
	
	/**
	 * ��������������ʵ���AGGVO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @param orderPath ���򼯺�
	 * @return �������
	 */
	public  AggQtcksqMasterVO[] listAggQtcksqMasterVOByCondition(String condition,String[] orderPath) throws BusinessException;
	
	/**
	 * ��������������ʵ�������VO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public QtcksqMasterVO[] listQtcksqMasterVOByPk(String...pks) throws BusinessException;
	
	/**
	 * ��������������ʵ�������VO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk ����
	 * @return �������
	 */
	public  QtcksqMasterVO findQtcksqMasterVOByPk(String pk) throws BusinessException;
	
	/**
	 * ��������������ʵ�������VO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  QtcksqMasterVO[] listQtcksqMasterVOByCondition(String condition) throws BusinessException;
	/**
	 * ��������������ʵ�������VO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  QtcksqMasterVO[] listQtcksqMasterVOByCondition(String condition,String[] orderPath) throws BusinessException;

	/**
	 * ��������������ʵ�������pk��ѯ����
	 * ���������ַ�����ѯpk��������
	 * @param condition ��ѯ����+
	 * @return �������
	 */
	public String[] listQtcksqMasterVOPkByCond(String condition) throws BusinessException;
	
	/**
	 * ��������������ʵ�������pk��ѯ����
	 * ���������ַ�����ѯpk��������
	 * @param condition ��ѯ����+
	 * @return �������
	 */
	public String[] listQtcksqMasterVOPkByCond(String condition,String[] orderPath) throws BusinessException;
	/**
	 * ����ʵ��vo����Ĭ��ֵ
	 * @param vo
	 */
	public void initDefaultData(QtcksqMasterVO vo);
	
	
	/**
	 * Ԥ����������������������ʵ������
	 * @param userJson  ����ʱ��Ҫ����չ��������
	 */
	public AggQtcksqMasterVO preAddAggQtcksqMasterVO(Map<String,Object> userJson) throws BusinessException;
	
	public AggQtcksqMasterVO preAddAggQtcksqMasterVO(AggQtcksqMasterVO vo,Map<String,Object> userJson) throws BusinessException;
	 /**
	 * Ԥ�༭������������������ʵ������
	 * @param userJson  ����ʱ��Ҫ����չ��������
	 */
	public AggQtcksqMasterVO preEditAggQtcksqMasterVO(String pk) throws BusinessException;
	
	 /**
	 * ���Ʋ�����������������ʵ������
	 * 
	 */
	public AggQtcksqMasterVO copyAggQtcksqMasterVO(String pk) throws BusinessException;
	/**
	 * ���������������������ʵ������
	 * @param vos �������
	 * @return @
	 */
	public AggQtcksqMasterVO[] saveAggQtcksqMasterVO(AggQtcksqMasterVO vo) throws BusinessException;

	public AggQtcksqMasterVO[] saveAggQtcksqMasterVO(AggQtcksqMasterVO[] vos) throws BusinessException;
	
	
	/**
	 * ɾ��������������������ʵ������
	 * @param vos ɾ������
	 * @return @
	 */
	public AggQtcksqMasterVO[] deleteAggQtcksqMasterVOs(Map<String,String> tsMap) throws BusinessException;
	
	/**
	 * ����������������������������ʵ��
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