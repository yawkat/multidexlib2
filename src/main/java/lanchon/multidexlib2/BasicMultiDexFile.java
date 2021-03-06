/*
 * DexPatcher - Copyright 2015-2017 Rodrigo Balerdi
 * (GNU General Public License version 3 or later)
 *
 * DexPatcher is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published
 * by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 */

package lanchon.multidexlib2;

import java.util.Set;

import org.jf.dexlib2.Opcodes;
import org.jf.dexlib2.iface.ClassDef;
import org.jf.dexlib2.iface.DexFile;
import org.jf.dexlib2.iface.MultiDexContainer;
import org.jf.dexlib2.iface.MultiDexContainer.MultiDexFile;

public class BasicMultiDexFile<C extends MultiDexContainer<? extends MultiDexFile>, D extends DexFile>
		implements WrappingMultiDexFile<D> {

	private final C container;
	private final String entryName;
	private final D dexFile;

	public BasicMultiDexFile(C container, String entryName, D dexFile) {
		this.container = container;
		this.entryName = entryName;
		this.dexFile = dexFile;
	}

	@Override
	public Set<? extends ClassDef> getClasses() {
		return dexFile.getClasses();
	}

	@Override
	public Opcodes getOpcodes() {
		return dexFile.getOpcodes();
	}

	@Override
	public String getEntryName() {
		return entryName;
	}

	@Override
	public C getContainer() {
		return container;
	}

	@Override
	public D getWrappedDexFile() {
		return dexFile;
	}

}
