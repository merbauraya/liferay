/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.idetronic.portlet.model.impl;

import com.idetronic.portlet.model.staff_active;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing staff_active in entity cache.
 *
 * @author Mazlan Mat
 * @see staff_active
 * @generated
 */
public class staff_activeCacheModel implements CacheModel<staff_active>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(53);

		sb.append("{bp_name=");
		sb.append(bp_name);
		sb.append(", bp_no_pekerja=");
		sb.append(bp_no_pekerja);
		sb.append(", bp_no_kp=");
		sb.append(bp_no_kp);
		sb.append(", bk_jab_hakiki=");
		sb.append(bk_jab_hakiki);
		sb.append(", bk_jab_hakiki_desc=");
		sb.append(bk_jab_hakiki_desc);
		sb.append(", bk_jab_sekarang=");
		sb.append(bk_jab_sekarang);
		sb.append(", bk_jab_sekarang_desc=");
		sb.append(bk_jab_sekarang_desc);
		sb.append(", bk_jaw_jenis=");
		sb.append(bk_jaw_jenis);
		sb.append(", al_alamat1=");
		sb.append(al_alamat1);
		sb.append(", al_alamat2=");
		sb.append(al_alamat2);
		sb.append(", al_alamat3=");
		sb.append(al_alamat3);
		sb.append(", al_poskod=");
		sb.append(al_poskod);
		sb.append(", al_bandar=");
		sb.append(al_bandar);
		sb.append(", al_negeri=");
		sb.append(al_negeri);
		sb.append(", al_negara=");
		sb.append(al_negara);
		sb.append(", bp_telefon=");
		sb.append(bp_telefon);
		sb.append(", bp_email=");
		sb.append(bp_email);
		sb.append(", bp_tjangka_bsara=");
		sb.append(bp_tjangka_bsara);
		sb.append(", bp_rekod_status=");
		sb.append(bp_rekod_status);
		sb.append(", bk_jaw_hakiki=");
		sb.append(bk_jaw_hakiki);
		sb.append(", bk_jaw_hakiki_desc=");
		sb.append(bk_jaw_hakiki_desc);
		sb.append(", bk_jaw_sekarang=");
		sb.append(bk_jaw_sekarang);
		sb.append(", bk_jaw_sekarang_desc=");
		sb.append(bk_jaw_sekarang_desc);
		sb.append(", bk_tarikh_lahir=");
		sb.append(bk_tarikh_lahir);
		sb.append(", bk_tarikh_masuk=");
		sb.append(bk_tarikh_masuk);
		sb.append(", bk_rekod_status=");
		sb.append(bk_rekod_status);
		sb.append("}");

		return sb.toString();
	}

	public staff_active toEntityModel() {
		staff_activeImpl staff_activeImpl = new staff_activeImpl();

		if (bp_name == null) {
			staff_activeImpl.setBp_name(StringPool.BLANK);
		}
		else {
			staff_activeImpl.setBp_name(bp_name);
		}

		if (bp_no_pekerja == null) {
			staff_activeImpl.setBp_no_pekerja(StringPool.BLANK);
		}
		else {
			staff_activeImpl.setBp_no_pekerja(bp_no_pekerja);
		}

		if (bp_no_kp == null) {
			staff_activeImpl.setBp_no_kp(StringPool.BLANK);
		}
		else {
			staff_activeImpl.setBp_no_kp(bp_no_kp);
		}

		if (bk_jab_hakiki == null) {
			staff_activeImpl.setBk_jab_hakiki(StringPool.BLANK);
		}
		else {
			staff_activeImpl.setBk_jab_hakiki(bk_jab_hakiki);
		}

		if (bk_jab_hakiki_desc == null) {
			staff_activeImpl.setBk_jab_hakiki_desc(StringPool.BLANK);
		}
		else {
			staff_activeImpl.setBk_jab_hakiki_desc(bk_jab_hakiki_desc);
		}

		if (bk_jab_sekarang == null) {
			staff_activeImpl.setBk_jab_sekarang(StringPool.BLANK);
		}
		else {
			staff_activeImpl.setBk_jab_sekarang(bk_jab_sekarang);
		}

		if (bk_jab_sekarang_desc == null) {
			staff_activeImpl.setBk_jab_sekarang_desc(StringPool.BLANK);
		}
		else {
			staff_activeImpl.setBk_jab_sekarang_desc(bk_jab_sekarang_desc);
		}

		if (bk_jaw_jenis == null) {
			staff_activeImpl.setBk_jaw_jenis(StringPool.BLANK);
		}
		else {
			staff_activeImpl.setBk_jaw_jenis(bk_jaw_jenis);
		}

		if (al_alamat1 == null) {
			staff_activeImpl.setAl_alamat1(StringPool.BLANK);
		}
		else {
			staff_activeImpl.setAl_alamat1(al_alamat1);
		}

		if (al_alamat2 == null) {
			staff_activeImpl.setAl_alamat2(StringPool.BLANK);
		}
		else {
			staff_activeImpl.setAl_alamat2(al_alamat2);
		}

		if (al_alamat3 == null) {
			staff_activeImpl.setAl_alamat3(StringPool.BLANK);
		}
		else {
			staff_activeImpl.setAl_alamat3(al_alamat3);
		}

		if (al_poskod == null) {
			staff_activeImpl.setAl_poskod(StringPool.BLANK);
		}
		else {
			staff_activeImpl.setAl_poskod(al_poskod);
		}

		if (al_bandar == null) {
			staff_activeImpl.setAl_bandar(StringPool.BLANK);
		}
		else {
			staff_activeImpl.setAl_bandar(al_bandar);
		}

		if (al_negeri == null) {
			staff_activeImpl.setAl_negeri(StringPool.BLANK);
		}
		else {
			staff_activeImpl.setAl_negeri(al_negeri);
		}

		if (al_negara == null) {
			staff_activeImpl.setAl_negara(StringPool.BLANK);
		}
		else {
			staff_activeImpl.setAl_negara(al_negara);
		}

		if (bp_telefon == null) {
			staff_activeImpl.setBp_telefon(StringPool.BLANK);
		}
		else {
			staff_activeImpl.setBp_telefon(bp_telefon);
		}

		if (bp_email == null) {
			staff_activeImpl.setBp_email(StringPool.BLANK);
		}
		else {
			staff_activeImpl.setBp_email(bp_email);
		}

		if (bp_tjangka_bsara == Long.MIN_VALUE) {
			staff_activeImpl.setBp_tjangka_bsara(null);
		}
		else {
			staff_activeImpl.setBp_tjangka_bsara(new Date(bp_tjangka_bsara));
		}

		if (bp_rekod_status == null) {
			staff_activeImpl.setBp_rekod_status(StringPool.BLANK);
		}
		else {
			staff_activeImpl.setBp_rekod_status(bp_rekod_status);
		}

		if (bk_jaw_hakiki == null) {
			staff_activeImpl.setBk_jaw_hakiki(StringPool.BLANK);
		}
		else {
			staff_activeImpl.setBk_jaw_hakiki(bk_jaw_hakiki);
		}

		if (bk_jaw_hakiki_desc == null) {
			staff_activeImpl.setBk_jaw_hakiki_desc(StringPool.BLANK);
		}
		else {
			staff_activeImpl.setBk_jaw_hakiki_desc(bk_jaw_hakiki_desc);
		}

		if (bk_jaw_sekarang == null) {
			staff_activeImpl.setBk_jaw_sekarang(StringPool.BLANK);
		}
		else {
			staff_activeImpl.setBk_jaw_sekarang(bk_jaw_sekarang);
		}

		if (bk_jaw_sekarang_desc == null) {
			staff_activeImpl.setBk_jaw_sekarang_desc(StringPool.BLANK);
		}
		else {
			staff_activeImpl.setBk_jaw_sekarang_desc(bk_jaw_sekarang_desc);
		}

		if (bk_tarikh_lahir == Long.MIN_VALUE) {
			staff_activeImpl.setBk_tarikh_lahir(null);
		}
		else {
			staff_activeImpl.setBk_tarikh_lahir(new Date(bk_tarikh_lahir));
		}

		if (bk_tarikh_masuk == Long.MIN_VALUE) {
			staff_activeImpl.setBk_tarikh_masuk(null);
		}
		else {
			staff_activeImpl.setBk_tarikh_masuk(new Date(bk_tarikh_masuk));
		}

		if (bk_rekod_status == null) {
			staff_activeImpl.setBk_rekod_status(StringPool.BLANK);
		}
		else {
			staff_activeImpl.setBk_rekod_status(bk_rekod_status);
		}

		staff_activeImpl.resetOriginalValues();

		return staff_activeImpl;
	}

	public String bp_name;
	public String bp_no_pekerja;
	public String bp_no_kp;
	public String bk_jab_hakiki;
	public String bk_jab_hakiki_desc;
	public String bk_jab_sekarang;
	public String bk_jab_sekarang_desc;
	public String bk_jaw_jenis;
	public String al_alamat1;
	public String al_alamat2;
	public String al_alamat3;
	public String al_poskod;
	public String al_bandar;
	public String al_negeri;
	public String al_negara;
	public String bp_telefon;
	public String bp_email;
	public long bp_tjangka_bsara;
	public String bp_rekod_status;
	public String bk_jaw_hakiki;
	public String bk_jaw_hakiki_desc;
	public String bk_jaw_sekarang;
	public String bk_jaw_sekarang_desc;
	public long bk_tarikh_lahir;
	public long bk_tarikh_masuk;
	public String bk_rekod_status;
}