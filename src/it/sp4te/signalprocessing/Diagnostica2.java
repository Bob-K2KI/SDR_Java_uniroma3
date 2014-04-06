package it.sp4te.signalprocessing;

import it.sp4te.domain.*;
import it.sp4te.signalprocessing.SignalProcessor;

public class Diagnostica2 {
	public static void main (String[] args){
		
		Complex[] vet1 = {new Complex(3,0), new Complex(2,0), new Complex(1,0)};
		
		/*
		// Esempio convoluzione tra reali
		double[] v1 = {3,2,1};
		double[] v2 = {1,1,2,1};
		double[] v3 = SignalProcessor.convoluzione(v1, v2);
		System.out.println("------------------");
		System.out.println("CONVOLUZIONE REALI");
		System.out.println("------------------");
		for(int i= 0; i< v3.length;i++)
			System.out.println(v3[i]);

		// esempio convoluzione tra Complessi		
		Complex[] vet2 = {new Complex(1,0), new Complex(2,0), new Complex(1,0), new Complex(1,0)};
		
		System.out.println("\n----------------------");
		System.out.println("CONVOLUZIONE COMPLESSI");
		System.out.println("----------------------");
		Complex[] vet3 = SignalProcessor.convoluzione(vet1, vet2);
		for(int i= 0; i< vet3.length;i++)
			System.out.println(vet3[i].toString());
	
		*/
		
		//esempio di filtraggio (convoluzione tra un segnale e il filtro passa-basso)
		
		Signal lpf= SignalProcessor.lowPassFilter(0.25, 5);
		Signal lpe= SignalProcessor.lowPassFilter(0.35);
		Signal s = new Signal(vet1);
		Signal f1 = SignalProcessor.convoluzione(s, lpf);
		Signal f2 = SignalProcessor.convoluzione(s, lpe);
		
		System.out.println("-------------");
		System.out.println("FILTRAGGIO LPF");
		System.out.println("--------------");
		
		System.out.println("Dato il segnale:");
		System.out.println(s.toString());
		System.out.println("Dato il Filtro normale:");
		System.out.println(lpf.toString());
		System.out.println("Filtrato NORMALE");
		System.out.println(f1.toString());
		
		System.out.println("Dato il Filtro intelligente:");
		System.out.println(lpe.toString());;
		System.out.println("Filtrato INTELLIGENTE");
		System.out.println(f2.toString());
		
		System.out.println("\n--------------");
		System.out.println("FILTRAGGIO BPF");
		System.out.println("--------------");
		
		System.out.println("Dato il segnale:");
		System.out.println(s.toString());
		Signal bpf= SignalProcessor.bandPassFilter(0.55,0.65);
		Signal lz = SignalProcessor.LazyBandPassFilter(0.60,0.10);
		System.out.println("");
		Signal f3 = SignalProcessor.convoluzione(s, bpf);
		Signal f4 = SignalProcessor.convoluzione(s, lz);
		System.out.println("Filtrato NORMALE");
		System.out.println(f3.toString());
		System.out.println("Filtrato LAZY");
		System.out.println(f4.toString());
	}
}