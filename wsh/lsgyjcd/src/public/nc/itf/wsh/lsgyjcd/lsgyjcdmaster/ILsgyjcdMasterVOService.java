
package nc.itf.wsh.lsgyjcd.lsgyjcdmaster;

import java.util.Map;

import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;

import nc.vo.lsgyjcd.lsgyjcd.AggLsgyjcdMasterVO;
import nc.vo.lsgyjcd.lsgyjcd.LsgyjcdMasterVO;

public interface  ILsgyjcdMasterVOService{

	/**
	 * ��ʱ���ս��̵���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public AggLsgyjcdMasterVO[] listAggLsgyjcdMasterVOByPk(String... pks) throws BusinessException;
	
	/**
	 * ��ʱ���ս��̵���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public AggLsgyjcdMasterVO[] listAggLsgyjcdMasterVOByPk(boolean blazyLoad,String... pks) throws BusinessException;
	
	/**
	 * ��ʱ���ս��̵���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk ����
	 * @return �������
	 */
	public  AggLsgyjcdMasterVO findAggLsgyjcdMasterVOByPk(String pk) throws BusinessException;
	
	/**
	 * ��ʱ���ս��̵���AGGVO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  AggLsgyjcdMasterVO[] listAggLsgyjcdMasterVOByCondition(String condition) throws BusinessException;
	
	/**
	 * ��ʱ���ս��̵���AGGVO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @param orderPath ���򼯺�
	 * @return �������
	 */
	public  AggLsgyjcdMasterVO[] listAggLsgyjcdMasterVOByCondition(String condition,String[] orderPath) throws BusinessException;
	
	/**
	 * ��ʱ���ս��̵�������VO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public LsgyjcdMasterVO[] listLsgyjcdMasterVOByPk(String...pks) throws BusinessException;
	
	/**
	 * ��ʱ���ս��̵�������VO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk ����
	 * @return �������
	 */
	public  LsgyjcdMasterVO findLsgyjcdMasterVOByPk(String pk) throws BusinessException;
	
	/**
	 * ��ʱ���ս��̵�������VO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  LsgyjcdMasterVO[] listLsgyjcdMasterVOByCondition(String condition) throws BusinessException;
	/**
	 * ��ʱ���ս��̵�������VO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  LsgyjcdMasterVO[] listLsgyjcdMasterVOByCondition(String condition,String[] orderPath) throws BusinessException;

	/**
	 * ��ʱ���ս��̵�������pk��ѯ����
	 * ���������ַ�����ѯpk��������
	 * @param condition ��ѯ����+
	 * @return �������
	 */
	public String[] listLsgyjcdMasterVOPkByCond(String condition) throws BusinessException;
	
	/**
	 * ��ʱ���ս��̵�������pk��ѯ����
	 * ���������ַ�����ѯpk��������
	 * @param condition ��ѯ����+
	 * @return �������
	 */
	public String[] listLsgyjcdMasterVOPkByCond(String condition,String[] orderPath) throws BusinessException;
	/**
	 * ����ʵ��vo����Ĭ��ֵ
	 * @param vo
	 */
	public void initDefaultData(LsgyjcdMasterVO vo);
	
	
	/**
	 * Ԥ����������ʱ���ս��̵�����
	 * @param userJson  ����ʱ��Ҫ����չ��������
	 */
	public AggLsgyjcdMasterVO preAddAggLsgyjcdMasterVO(Map<String,Object> userJson) throws BusinessException;
	
	public AggLsgyjcdMasterVO preAddAggLsgyjcdMasterVO(AggLsgyjcdMasterVO vo,Map<String,Object> userJson) throws BusinessException;
	 /**
	 * Ԥ�༭������ʱ���ս��̵�����
	 * @param userJson  ����ʱ��Ҫ����չ��������
	 */
	public AggLsgyjcdMasterVO preEditAggLsgyjcdMasterVO(String pk) throws BusinessException;
	
	 /**
	 * ���Ʋ�����ʱ���ս��̵�����
	 * 
	 */
	public AggLsgyjcdMasterVO copyAggLsgyjcdMasterVO(String pk) throws BusinessException;
	/**
	 * ���������ʱ���ս��̵�����
	 * @param vos �������
	 * @return @
	 */
	public AggLsgyjcdMasterVO[] saveAggLsgyjcdMasterVO(AggLsgyjcdMasterVO vo) throws BusinessException;

	public AggLsgyjcdMasterVO[] saveAggLsgyjcdMasterVO(AggLsgyjcdMasterVO[] vos) throws BusinessException;
	
	
	/**
	 * ɾ��������ʱ���ս��̵�����
	 * @param vos ɾ������
	 * @return @
	 */
	public AggLsgyjcdMasterVO[] deleteAggLsgyjcdMasterVOs(Map<String,String> tsMap) throws BusinessException;
	
	/**
	 * ����������������ʱ���ս��̵�
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