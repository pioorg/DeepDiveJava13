package org.przybyl.ddj13;

/**
 *
 * Let's try to run this the following ways:
 *
 * time java --enable-preview -Xms4G -Xmx8G -XX:StartFlightRecording=disk=true,dumponexit=true,filename=/tmp/G1.jfr,maxsize=1024m,settings=profile org.przybyl.ddj13.GCQuasiBenchmark
 * time java --enable-preview -XX:+UseParallelOldGC -Xms4G -Xmx8G -XX:StartFlightRecording=disk=true,dumponexit=true,filename=/tmp/ParallelOld.jfr,maxsize=1024m,settings=profile org.przybyl.ddj13.GCQuasiBenchmark
 * time java --enable-preview -XX:+UseConcMarkSweepGC -Xms4G -Xmx8G -XX:StartFlightRecording=disk=true,dumponexit=true,filename=/tmp/CMS.jfr,maxsize=1024m,settings=profile org.przybyl.ddj13.GCQuasiBenchmark
 * time java --enable-preview -XX:+UnlockExperimentalVMOptions -XX:+UseShenandoahGC -Xms4G -Xmx8G -XX:StartFlightRecording=disk=true,dumponexit=true,filename=/tmp/Shenandoah.jfr,maxsize=1024m,settings=profile org.przybyl.ddj13.GCQuasiBenchmark
 * time java --enable-preview -XX:+UnlockExperimentalVMOptions -XX:+UseZGC -Xms4G -Xmx8G -XX:StartFlightRecording=disk=true,dumponexit=true,filename=/tmp/ZGC.jfr,maxsize=1024m,settings=profile org.przybyl.ddj13.GCQuasiBenchmark
 */
public class GCQuasiBenchmark {
	public static void main(String... args) {

	}
}
