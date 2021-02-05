package com.saad.maximatechtest.client.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.saad.maximatechtest.databinding.FragmentClientBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ClientFragment : Fragment(), ClientContract.View {
    @Inject lateinit var presenter: ClientContract.Presenter
    private var _binding: FragmentClientBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentClientBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.getClientInfo()
    }

    override fun showCompanyNameWithCode(name: String) {
        binding.cardClientCompanyName.text = name
    }

    override fun showFantasyName(fantasyName: String) {
        binding.cardClientFantasyName.text = fantasyName
    }

    override fun showCpf(cpf: String) {
        binding.cardClientCpf.setValue(cpf)
    }

    override fun showCnpj(cnpj: String) {
        binding.cardClientCnpj.setValue(cnpj)
    }

    override fun showActivityBranch(activityBranch: String) {
        binding.cardClientActivityBranch.setValue(activityBranch)
    }

    override fun showAddress(address: String) {
        binding.cardClientAddress.setValue(address)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}