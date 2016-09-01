package com.tim.shadow.ball;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;

public class MainActivity extends Activity implements SensorEventListener {

	GLSurfaceView mGlSurfaceView;
	Ball mBall;
	private float mPreviousY;
	private float mPreviousX;
	// ������Ӧ
	private SensorManager sensorManager;
	private Sensor magneticSensor;
	private Sensor accelerometerSensor;
	private Sensor gyroscopeSensor;
	// ������ת��Ϊ��
	private static final float NS2S = 1.0f / 1000000000.0f;
	private float timestamp;
	private float angle[] = new float[3];
	private float Y = 10f;
	private SensorInfo info = new SensorInfo();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mGlSurfaceView = new GLSurfaceView(this);
		mGlSurfaceView.setEGLContextClientVersion(2);
		mBall = new Ball(this);
		mGlSurfaceView.setRenderer(mBall);
		setContentView(mGlSurfaceView);
		initSensor();
	}

	private void initSensor() {
		sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		magneticSensor = sensorManager
				.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
		accelerometerSensor = sensorManager
				.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		gyroscopeSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
		// ע�������Ǵ����������趨��������Ӧ���������ʱ����������SensorManager.SENSOR_DELAY_GAME(20000΢��)
		// SensorManager.SENSOR_DELAY_FASTEST(0΢��)����졣����ӳ٣�һ�㲻���ر����еĴ����Ƽ�ʹ�ã���ģʽ�����ڳ��ֻ������������ģ����ڴ��ݵ�Ϊԭʼ���ݣ��߷�������û�Ӱ����Ϸ�߼���UI������
		// SensorManager.SENSOR_DELAY_GAME(20000΢��)����Ϸ����Ϸ�ӳ٣�һ����������ʵʱ�Խϸߵ���Ϸ�����øü���
		// SensorManager.SENSOR_DELAY_NORMAL(200000΢��):��ͨ����׼��ʱ������һ����������EASY�������Ϸ����ʹ�ã������͵Ĳ����ʿ��ܶ�һЩ��������Ϸ����֡����
		// SensorManager.SENSOR_DELAY_UI(60000΢��):�û����档һ�������Ļ�����Զ���תʹ�ã���Խ�ʡ���ܺ��߼�����һ����Ϸ�����в�ʹ��
		sensorManager.registerListener(this, gyroscopeSensor,
				SensorManager.SENSOR_DELAY_FASTEST);
		sensorManager.registerListener(this, magneticSensor,
				SensorManager.SENSOR_DELAY_FASTEST);
		sensorManager.registerListener(this, accelerometerSensor,
				SensorManager.SENSOR_DELAY_FASTEST);


	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		System.out.println(keyCode);
		if(keyCode == 22){
			System.out.println("�������Ҽ�");

			info.setSensorY(info.getSensorY());
			info.setSensorX(info.getSensorX()+5f);
			info.setSensorZ(info.getSensorZ());

		}else if(keyCode == 21){
			info.setSensorY(info.getSensorY());
			info.setSensorX(info.getSensorX()-5f);
			info.setSensorZ(info.getSensorZ());

		}else if(keyCode == 19){
			info.setSensorY(info.getSensorY()+5f);
			info.setSensorX(info.getSensorX());
			info.setSensorZ(info.getSensorZ());

		}else if(keyCode == 20){
			info.setSensorY(info.getSensorY()-5f);
			info.setSensorX(info.getSensorX());
			info.setSensorZ(info.getSensorZ());

		}
		Message msg = new Message();
		msg.what = 101;
		msg.obj = info;
		mHandler.sendMessage(msg);

		return super.onKeyDown(keyCode, event);
	}

	@Override
	public boolean onTouchEvent(MotionEvent e) {
		float y = e.getY();
		float x = e.getX();
		switch (e.getAction()) {
		case MotionEvent.ACTION_MOVE:
			float dy = y - mPreviousY;// ���㴥�ر�Yλ��
			float dx = x - mPreviousX;// ���㴥�ر�Xλ��
			mBall.yAngle += dx * 0.3f;// ���������Բ��y����ת�ĽǶ�
			mBall.xAngle += dy * 0.3f;// ���������Բ��x����ת�ĽǶ�
		}
		mPreviousY = y;// ��¼���ر�λ��
		mPreviousX = x;// ��¼���ر�λ��
		return true;
	}


	@Override
	protected void onResume() {
		super.onResume();
		if (null != mGlSurfaceView) {
			mGlSurfaceView.onResume();
		}
	}

	@Override
	protected void onPause() {
		super.onPause();
		if (null != mGlSurfaceView) {
			mGlSurfaceView.onPause();
		}
//		sensorManager.unregisterListener(this);
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub

	}

	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	@Override
	public void onSensorChanged(SensorEvent event) {

		if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
			// x,y,z�ֱ�洢������x,y,z�ϵļ��ٶ�
			float x = event.values[0];
			float y = event.values[1];
			float z = event.values[2];
			// �������������ϵļ��ٶ�ֵ�õ��ܵļ��ٶ�ֵa
			float a = (float) Math.sqrt(x * x + y * y + z * z);
			System.out.println("a---------->" + a);
			// �����������ɼ����ݵ�ʱ����Ϊ10000΢��
			System.out.println("magneticSensor.getMinDelay()-------->"
					+ magneticSensor.getMinDelay());
			// ���ٶȴ��������������
			System.out.println("event.sensor.getMaximumRange()-------->"
					+ event.sensor.getMaximumRange());

			System.out.println("x------------->" + x);
			System.out.println("y------------->" + y);
			System.out.println("z------------->" + z);

			Log.d("TAG", "x------------->" + x);
			Log.d("TAG", "y------------>" + y);
			Log.d("TAG", "z----------->" + z);
			

			// showTextView.setText("x---------->" + x + "\ny-------------->" +
			// y + "\nz----------->" + z);
		} else if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
			// ���������᷽���ϵĵ��ǿ�ȣ���λ��΢����˹(micro-Tesla)����uT��ʾ��Ҳ�����Ǹ�˹(Gauss),1Tesla=10000Gauss
			float x = event.values[0];
			float y = event.values[1];
			float z = event.values[2];
			// �ֻ��Ĵų���Ӧ�����ⲿ�ɼ����ݵ�ʱ������10000΢��
			System.out.println("magneticSensor.getMinDelay()-------->"
					+ magneticSensor.getMinDelay());
			// �ų���Ӧ�����������
			System.out.println("event.sensor.getMaximumRange()----------->"
					+ event.sensor.getMaximumRange());
			System.out.println("x------------->" + x);
			System.out.println("y------------->" + y);
			System.out.println("z------------->" + z);
//			SensorInfo info = new SensorInfo();
//			info.setSensorX(x);
//			info.setSensorY(y);
//			info.setSensorZ(z);
//			Message msg = new Message();
//			msg.what = 101;
//			msg.obj = info;
//			mHandler.sendMessage(msg);
			//
			// Log.d("TAG","x------------->" + x);
			// Log.d("TAG", "y------------>" + y);
			// Log.d("TAG", "z----------->" + z);
			//
			// showTextView.setText("x---------->" + x + "\ny-------------->" +
			// y + "\nz----------->" + z);
		} else if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE) {
			// �� x��y��z �������λ�ùۿ�����ԭʼ��λ���豸������豸��ʱ����ת�������յ���ֵ������Ϊ��ֵ
			if (timestamp != 0) {
				// �õ����μ�⵽�ֻ���ת��ʱ�����룩��������ת��Ϊ��
				final float dT = (event.timestamp - timestamp) * NS2S;
				// ���ֻ��ڸ������ϵ���ת�Ƕ���ӣ����ɵõ���ǰλ������ڳ�ʼλ�õ���ת����
				angle[0] += event.values[0] * dT;
				angle[1] += event.values[1] * dT;
				angle[2] += event.values[2] * dT;
				// ������ת��Ϊ�Ƕ�
				float anglex = (float) Math.toDegrees(angle[0]);
				float angley = (float) Math.toDegrees(angle[1]);
				float anglez = (float) Math.toDegrees(angle[2]);

				System.out.println("anglex------------>" + anglex);
				System.out.println("angley------------>" + angley);
				System.out.println("anglez------------>" + anglez);
				SensorInfo info = new SensorInfo();
				info.setSensorX(angley);
				info.setSensorY(anglex);
				info.setSensorZ(anglez);
				Message msg = new Message();
				msg.what = 101;
				msg.obj = info;
				mHandler.sendMessage(msg);

				System.out.println("gyroscopeSensor.getMinDelay()----------->"
						+ gyroscopeSensor.getMinDelay());
			}
			// ����ǰʱ�丳ֵ��timestamp
			timestamp = event.timestamp;

		}else if(event.sensor.getType()==Sensor.TYPE_ORIENTATION){
			
		}

	}

	Handler mHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case 101:
				SensorInfo info = (SensorInfo) msg.obj;
				float y = info.getSensorY();
				float x = info.getSensorX();
				float dy = y - mPreviousY;// ���㴥�ر�Yλ��
				float dx = x - mPreviousX;// ���㴥�ر�Xλ��
				mBall.yAngle += dx * 1.0f;// ���������Բ��y����ת�ĽǶ�
				mBall.xAngle += dy * 1.0f;// ���������Բ��x����ת�ĽǶ�
				mPreviousY = y;// ��¼���ر�λ��
				mPreviousX = x;// ��¼���ر�λ��
				break;

			default:
				break;
			}
		};
	};

}
